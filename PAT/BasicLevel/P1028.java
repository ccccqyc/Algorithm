import java.util.Scanner;

/**
 * 测试点4超时..
 * C++ 通过.
 * Created by q on 17-9-6.
 */
public class P1028 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        PeoTest[] peoples = new PeoTest[length];
        String[] people;
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            people = scanner.nextLine().replace("/", " ").split(" ");
            peoples[i] = new PeoTest(people[0], Integer.parseInt(people[1]), Integer.parseInt(people[2]), Integer.parseInt(people[3]));
        }
        scanner.close();

        PeoTest oldPeople = new PeoTest("", 1814, 9, 6);
        PeoTest youngPeople = new PeoTest("", 2014, 9, 6);

        int count = 0;
        //min
        PeoTest No0Peo = oldPeople;
        //max
        PeoTest NolPeo = youngPeople;
        for (int i = 0; i < length; i++) {
            //等号成立于同一天.
            if ((peoples[i].compareTo(oldPeople) >= 0) && (peoples[i].compareTo(youngPeople) <= 0)) {
                count++;
                NolPeo = peoples[i].compareTo(NolPeo) < 0 ? peoples[i] : NolPeo;
                No0Peo = peoples[i].compareTo(No0Peo) > 0 ? peoples[i] : No0Peo;
            }
        }
        if (count == 0) {
            System.out.print(0);
        } else {
            System.out.print(count + " " + NolPeo.getName() + " " + No0Peo.getName());
        }

    }
}

class PeoTest implements Comparable<PeoTest> {
    private String name;
    private int year;
    private int month;
    private int day;

    public String getName() {
        return name;
    }

    public PeoTest(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(PeoTest o) {
        if (this.year > o.year) {
            return 1;
        } else if (this.year < o.year) {
            return -1;
        } else {
            if (this.month > o.month) {
                return 1;
            } else if (this.month < o.month) {
                return -1;
            } else {
                if (this.day > o.day) {
                    return 1;
                } else if (this.day < o.day) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}

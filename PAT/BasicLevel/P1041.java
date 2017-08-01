import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by q on 17-7-29.
 */
public class P1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            students[i] = new Student(strings[0], strings[1], strings[2]);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        String[] test = bufferedReader.readLine().split(" ");

        bufferedReader.close();
        for (int i = 0; i < m; i++) {
            String findTestSeat = test[i];

            for (int j = 0; j < n; j++) {
                if (students[j].testSeat.equals(findTestSeat)) {
                    System.out.println(students[j].id + " " + students[j].seat);
                }
            }
        }
    }
}

class Student {
    String id;
    String testSeat;
    String seat;

    public Student(String id, String testSeat, String seat) {
        this.id = id;
        this.testSeat = testSeat;
        this.seat = seat;
    }
}

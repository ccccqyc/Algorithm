import java.util.Arrays;
import java.util.Scanner;

/**
 * 测试点2,3,4超时..
 * Created by q on 17-9-5.
 */
public class P1015 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int Lgrade = scanner.nextInt();
        int Hgrade = scanner.nextInt();

        Examinee[] examinees = new Examinee[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            examinees[i] = new Examinee(scanner.next(), scanner.nextInt(), scanner.nextInt(), Hgrade, Lgrade);
            if (examinees[i].level != 5) {
                count++;
            }
        }
        scanner.close();

        Arrays.sort(examinees);
        System.out.println(count);
        for (int i = length - 1; i > length - count - 1; i--) {
            System.out.println(examinees[i].ID + " " + examinees[i].Dg + " " + examinees[i].Cg);
        }
    }
}

class Examinee implements Comparable<Examinee> {

    public String ID;
    public int Dg;
    public int Cg;
    public int level;
    private int Hgrade;
    private int Lgrade;

    public Examinee(String ID, int dg, int cg, int hgrade, int lgrade) {
        this.ID = ID;
        Dg = dg;
        Cg = cg;
        Hgrade = hgrade;
        Lgrade = lgrade;
        setLevel();
    }

    private void setLevel() {
        this.level = theLevel(Hgrade, Lgrade);
    }

    @Override
    public int compareTo(Examinee examinee) {
        int a = 1;
        if (this.level == examinee.level) {
            if ((this.Dg + this.Cg) > (examinee.Dg + examinee.Cg)) {
                a = 1;
            } else if ((this.Dg + this.Cg) == (examinee.Dg + examinee.Cg)) {
                if (this.Dg > examinee.Dg) {
                    a = 1;
                } else if (this.Dg < examinee.Dg) {
                    a = -1;
                } else {
                    a = -this.ID.compareTo(examinee.ID);
                }
            } else {
                a = -1;
            }
        } else if (this.level > examinee.level) {
            a = -1;
        }
        return a;
    }

    private int theLevel(int Hgrade, int Lgrade) {
        if (Dg >= Lgrade && Cg >= Lgrade) {
            if (Dg >= Hgrade && Cg >= Hgrade) {
                return 1;
            } else if (Dg >= Hgrade && (Cg < Hgrade && Cg >= Lgrade)) {
                return 2;
            } else if ((Dg >= Lgrade && Dg < Hgrade) && (Cg >= Lgrade && Cg < Hgrade) && (Dg >= Cg)) {
                return 3;
            } else {
                return 4;
            }
        } else {
            return 5;
        }

    }
}

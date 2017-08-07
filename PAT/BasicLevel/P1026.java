import java.util.Scanner;

/**
 * Created by q on 17-8-7.
 */
public class P1026 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float begin = in.nextFloat();
        float end = in.nextFloat();
        in.close();
        int seconds = Math.round((end-begin)/100);
        int minutes = 0;
        int hours = 0;

        if (seconds>59){
            minutes = seconds/60;
            seconds = seconds%60;
        }
        if (minutes >59){
            hours = minutes/60;
            minutes = minutes%60;
        }
        System.out.printf("%02d:%02d:%02d",hours,minutes,seconds);
    }
}

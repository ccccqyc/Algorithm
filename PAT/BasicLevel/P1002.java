import java.util.Scanner;

/**
 * Created by q on 17-8-14.
 */
public class P1002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        in.close();

        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            sum += Integer.parseInt(String.valueOf(string.charAt(i)));
        }

        String sumString = String.valueOf(sum);
        for (int i = 0; i < sumString.length(); i++) {
            System.out.print(transfer(sumString.charAt(i)));
            if(i!=sumString.length()-1){
                System.out.print(" ");
            }

        }
    }
    private static String transfer(char c){
        String s = "";
        switch (c){
            case '0':
                s="ling";
                break;
            case '1':
                s="yi";
                break;
            case '2':
                s="er";
                break;
            case '3':
                s="san";
                break;
            case '4':
                s="si";
                break;
            case '5':
                s="wu";
                break;
            case '6':
                s="liu";
                break;
            case '7':
                s="qi";
                break;
            case '8':
                s="ba";
                break;
            case '9':
                s="jiu";
                break;
        }
        return s;
    }
}

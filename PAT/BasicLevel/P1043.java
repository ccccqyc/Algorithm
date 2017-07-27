package BasicLevel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by q on 17-7-27.
 */
public class P1043 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        in.close();

        int Pcount = 0;
        int Acount = 0;
        int Tcount = 0;
        int ecount = 0;
        int scount = 0;
        int tcount = 0;


        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case 'P':
                    Pcount++;
                    break;
                case 'A':
                    Acount++;
                    break;
                case 'T':
                    Tcount++;
                    break;
                case 'e':
                    ecount++;
                    break;
                case 's':
                    scount++;
                    break;
                case 't':
                    tcount++;
                    break;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(Pcount);
        list.add(Acount);
        list.add(Tcount);
        list.add(ecount);
        list.add(scount);
        list.add(tcount);

        int count = Collections.max(list);

        for (int i = 0; i < count; i++) {
            if (Pcount != 0) {
                System.out.print('P');
                Pcount--;
            }
            if (Acount != 0) {
                System.out.print('A');
                Acount--;
            }
            if (Tcount != 0) {
                System.out.print('T');
                Tcount--;
            }
            if (ecount != 0) {
                System.out.print('e');
                ecount--;
            }
            if (scount != 0) {
                System.out.print('s');
                scount--;
            }
            if (tcount != 0) {
                System.out.print('t');
                tcount--;
            }
        }
    }
}



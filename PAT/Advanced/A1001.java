import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * ×Ö·û´® 
 * 
 * ÊäÈëÊä³ö BufferedReader StringBuilder
 * 
 * 
 * @author charQ
 *
 */
public class A1001 {
	public static void main(String[] args) {
		func();
	}

	/**
	 * All pass. Created by q on 17-8-23.
	 */
	public static void func1() {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String c = String.valueOf(Math.abs(a + b));
		scanner.close();

		StringBuilder s = new StringBuilder("");
		int length = c.length();
		s.append(String.copyValueOf(c.toCharArray(), 0, length % 3));
		if (length % 3 != 0 && length > 3) {
			s.append(',');
		}
		for (int i = c.length() % 3; i < length; i += 3) {
			s.append(String.copyValueOf(c.toCharArray(), i, 3));
			if (i != length - 3) {
				s.append(',');
			}
		}
		if (a + b < 0) {
			s.insert(0, '-');
		}
		System.out.println(s);
	}

	/**
	 * all pass . on 21-8-19
	 */
	public static void func() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder s = null;
		try {
			s = new StringBuilder(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		s = new StringBuilder(Integer
				.toString((Integer.valueOf(s.toString().split(" ")[0]) + Integer.valueOf(s.toString().split(" ")[1]))));

		if (s.charAt(0) == '-') {
			System.out.print("-");
			s.deleteCharAt(0);
		}

		int length = s.length();
		int count = length / 3;
		int first = length % 3;

		for (int i = 0; i < first; i++) {
			System.out.print(s.charAt(i));
		}
		for (int i = 0; i < count; i++) {
			if (!(first == 0 && i == 0))
				System.out.print(",");

			for (int j = 0; j < 3; j++) {
				System.out.print(s.charAt(j + i * 3 + first));
			}
		}
	}
}

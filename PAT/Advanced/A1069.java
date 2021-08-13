import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A1069 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			str = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			str = printC(str);
			if (str.equals("6174") || str.equals("0000")) {
				break;
			} else {
				System.out.println();
			}
		}

	}

	public static String printC(String str) {
		char[] chars = str.toCharArray();
		char[] chars2 = fill(chars);
		Arrays.sort(chars2);
		char[] chars1 = reservechar(chars2);
		String s1 = charsToString(chars1);
		String s2 = charsToString(chars2);
		int int3 = Integer.parseInt(s1) - Integer.parseInt(s2);
		String s3 = charsToString(fill(Integer.toString(int3).toCharArray()));
		System.out.print(s1 + " - " + s2 + " = " + s3);
		return s3;

	}

	/**
	 * 21 ¡ú 0021
	 * 
	 * @param chars
	 * @return
	 */
	public static char[] fill(char[] chars) {
		char[] temp = { '0', '0', '0', '0' };
		for (int i = 3; i > (3 - chars.length); i--) {
			temp[i] = chars[i + chars.length - 4];
		}
		return temp;
	}

	/**
	 * 0012 ¡ú 2100
	 * 
	 * @param chars
	 * @return
	 */
	public static char[] reservechar(char[] chars) {
		char temp;
		char[] tempchars = chars.clone();
		for (int i = 0; i < 2; i++) {
			temp = tempchars[i];
			tempchars[i] = tempchars[chars.length - i - 1];
			tempchars[chars.length - i - 1] = temp;
		}

		return tempchars;
	}

	/**
	 * char[] ¡ú String {'1','2','5'} ¡ú "125"
	 * 
	 * @param chars
	 * @return
	 */
	public static String charsToString(char[] chars) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : chars) {
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
}

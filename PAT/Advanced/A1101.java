import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A1101 {

	public static void main(String[] args) {
		func();

	}
	public static void func() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		try {
			count = Integer.valueOf(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		int[] array = new int[count];
		StringBuilder str = null;
		try {
			str = new StringBuilder(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringTokenizer tokenizedr = new StringTokenizer(str.toString());
		for (int i = 0; i < count; i++) {
			array[i] = Integer.valueOf(tokenizedr.nextToken());
		}
		int[] arraycopy = array.clone();
		Arrays.sort(arraycopy);
		ArrayList<Integer> al = new ArrayList<>();
		int max= array[0];
		for (int i = 0; i < count; i++) {
			if (array[i] <= arraycopy[i]&&max<=array[i]) {
				al.add(array[i]);
			}
			if(max<array[i]) {
				max = array[i];
			}
		}
		System.out.println(al.size());
		for (int i = 0; i < al.size(); i++) {
			System.out.print(al.get(i));
			if(i!=al.size()-1) {
				System.out.print(" ");
			}
		}
	}
	public static void func2() {
		
	}
}

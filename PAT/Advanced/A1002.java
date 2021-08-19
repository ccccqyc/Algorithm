import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 字符串
 * 输入输出格式
 * @author charQ
 *
 */
public class A1002 {

	public static void main(String[] args) {
		fuc();
	}

	public static void fuc() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder[] strs = new StringBuilder[2];

		try {
			strs[0] = new StringBuilder(bufferedReader.readLine().toString());
			strs[1] = new StringBuilder(bufferedReader.readLine().toString());
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringTokenizer st = null;
		int count = 0;
		float[] arr = new float[1002];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(strs[i].toString());
			count = Integer.valueOf(st.nextToken());
			for (int j = 0; j < count; j++) {
				arr[Integer.valueOf(st.nextToken())] += Float.valueOf(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		int count2 = 0;
		for (int i = arr.length-1; i >=0 ; i--) {
			if (arr[i] != 0) {
				count2++;
				sb.append(" ").append(i).append(" ").append(String.format("%.1f", arr[i]));
			}
		}
		sb.insert(0, count2);
		System.out.print(sb);
	}
}

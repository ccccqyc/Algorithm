import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.sun.media.sound.MidiUtils.TempoCache;

/**
 * 链表
 * 
 * @author charQ
 *
 */
public class A1097 {

	public static void main(String[] args) {
		fun();
	}

	public static void fun() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Node[] nodes = new Node[100001];
		StringTokenizer stringTokenizer = null;

		try {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		String firsrtaddress = stringTokenizer.nextToken(); // nodes 和 nodes1中第一个节点地址
		int count = Integer.parseInt(stringTokenizer.nextToken());
		int[] arrint = new int[10001];
		Arrays.fill(arrint, 0);

		int tempkey;
		int address;

		for (int i = 0; i < count; i++) {
			try {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}

			address = Integer.parseInt(stringTokenizer.nextToken());
			tempkey = Integer.parseInt(stringTokenizer.nextToken());

			Node node = new Node();
			node.key = tempkey;
			node.nextaddress = stringTokenizer.nextToken();

			nodes[address] = node;
		}

		int node2length = 0;

		Node node1 = nodes[Integer.parseInt(firsrtaddress)];
		String tempaddress = node1.nextaddress;// node1 → node2 node2的地址.
		Node tempnode = nodes[Integer.parseInt(tempaddress)];

		Node node2 = null;
		String secondaddress = null;
		for (int i = 0; i < count; i++) {
			tempkey = tempnode.key;

			if (arrint[Math.abs(tempkey)] == 1) {
				if (node2length != 0) {
					node2.nextaddress = tempaddress;
				} else {
					secondaddress = tempaddress;
					node2length++;
				}
				node2 = tempnode;
			} else {
				arrint[Math.abs(tempkey)] = 1;
				node1.nextaddress = tempaddress;
				node1 = tempnode;
			}
			
			tempaddress = tempnode.nextaddress;
			if(!tempaddress.equals("-1")) {
			tempnode = nodes[Integer.parseInt(tempaddress)];
			}		}

		node1.nextaddress = "-1";
		node2.nextaddress = "-1";

		node1 = nodes[Integer.parseInt(firsrtaddress)];
		node2 = nodes[Integer.parseInt(secondaddress)];
		while (node1.nextaddress != "-1") {
			pr(firsrtaddress, node1);
			firsrtaddress = node1.nextaddress;
			node1 = nodes[Integer.parseInt(firsrtaddress)];
		}

		node2 = nodes[Integer.parseInt(secondaddress)];
		while (node2.nextaddress != "-1") {
			pr(secondaddress, node2);
			secondaddress = node2.nextaddress;
			node2 = nodes[Integer.parseInt(secondaddress)];
		}
	}

	public static void pr(String address, Node nodes) {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(fill0(address)).append(" ").append(nodes.key).append(" ")
				.append(nodes.nextaddress.equals("-1") ? nodes.nextaddress : fill0(nodes.nextaddress) + "\n");
		System.out.print(stringBuilder);
	}

	public static String fill0(String str) {
		StringBuilder stringBuilder = new StringBuilder(str);
		int length = str.length();
		if (length < 5) {
			for (int i = 0; i < 5 - length; i++) {
				stringBuilder.insert(0, "0");
			}
		}
		return stringBuilder.toString();
	}

	static class Node {
		String nextaddress;
		int key;

	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 测试点 3.4.5超时
 * Created by q on 17-8-15.
 */
public class P1055 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //人数
        int peopleNum = in.nextInt();
        //排数
        int row = in.nextInt();
        in.nextLine();
        People[] peoples = new People[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            peoples[i] = new People(in.next(), in.nextInt());
        }
        in.close();
        Arrays.sort(peoples);

        //每排人数
        int rowPeoNum = peopleNum / row;
        People[] subRowPeoNum = Arrays.copyOfRange(peoples, (row - 1) * rowPeoNum, peoples.length);

        List<People[]> list = new ArrayList<>();
        for (int i = (row - 1) * rowPeoNum; i > 0; i -= rowPeoNum) {
            list.add(subRowPeoNum);
            subRowPeoNum = Arrays.copyOfRange(peoples, i - rowPeoNum, i);
        }
        list.add(subRowPeoNum);
        //临时数组
        People[] temp;
        //每排最高的人
        int hightPeo;
        int right;
        int left;

        for (People[] aList : list) {
            subRowPeoNum = aList;
            temp = subRowPeoNum.clone();
            //利用除法,数组从零开始这两个特性
            hightPeo = subRowPeoNum.length / 2;
            right = hightPeo + 1;
            left = hightPeo - 1;
            temp[hightPeo] = subRowPeoNum[subRowPeoNum.length - 1];
            for (int j = subRowPeoNum.length - 2; j >= 0; j--) {
                temp[left--] = subRowPeoNum[j];
                if (j > 0) {
                    temp[right++] = subRowPeoNum[--j];
                }
            }
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[j].getName());
                if (j != subRowPeoNum.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

class People implements Comparable<People> {
    private String name;
    private int high;

    People(String name, int high) {
        this.name = name;
        this.high = high;
    }

    String getName() {
        return name;
    }

    @Override
    /*
     定义排序特性.
      身高增序,身高同则姓名字典序.
     */
    public int compareTo(People people) {
        if (this.high < people.high) {
            return -1;
        } else if (this.high > people.high) {
            return 1;
        } else {
            return people.name.compareTo(this.name);
        }
    }
}
package normal;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author QYC
 * @date : 2022/01/18/8:32
 */
public class MedianFinder {

    ArrayList<Integer> arrayList;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        arrayList = new ArrayList<>();
    }

    public void addNum(int num) {
        arrayList.add(num);
        arrayList.sort(Comparator.naturalOrder());
    }

    public double findMedian() {
        if (arrayList.size()==0){
            return -1;
        }
        double ret;
        if (arrayList.size() % 2 == 1) {
            ret = arrayList.get(arrayList.size() / 2);
        } else {
            ret = (arrayList.get(arrayList.size() / 2) + arrayList.get(arrayList.size() / 2 - 1)) / 2.0;
        }
        return ret;
    }
}

package normal;

import java.util.Stack;

/**
 * 用两个栈实现队列,以及其中两个函数
 * <p>
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 *
 * @author : ccccqyc
 * @date : 2022/01/02/10:31
 */
public class CQueue {
    private final Stack<Integer> s1;
    private final Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        int temp;
        if (s1.empty()) {
            temp = -1;
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            temp = s2.pop();
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
        }
        return temp;
    }
}



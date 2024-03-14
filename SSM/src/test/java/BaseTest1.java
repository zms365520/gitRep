import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: zms
 * @Date: 2024/3/11 - 03 - 11 - 14:58
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class BaseTest1 {
    public static void main(String[] args) {
        //队列
        /*Queue<Integer> q = new LinkedList<>();
        q.offer(3);
        q.offer(6);
        q.offer(9);
        q.offer(12);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q);*/


        //栈
        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);

        System.out.println(s.pop());//删除栈顶元素
        System.out.println(s);

        System.out.println(s.isEmpty());
        System.out.println(s.peek());//获取栈顶元素
        System.out.println(s);


        Map<String,String> map=new HashMap<>();

    }
}

package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int[] priorities = {2, 5, 18};

        int location = 2;
//        int location = 0;
//        int location = 0;
        System.out.println("answer : " + solution(priorities, location));
    }

    static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int priority : priorities) {
            queue.add(priority);
        }
        do {
            boolean enablePrint = true;
            int checkValue = queue.poll();
            for (int queueValue : queue) {
                if (checkValue < queueValue) {
                    enablePrint = false;
                    queue.add(checkValue);
                    if (location == 0) {
                        location = queue.size() - 1;
                    } else {
                        location -= 1;
                    }
                    break;
                }
            }
            if (enablePrint) {
                answer++;
                if (location == 0) {
                    break;
                }
                location -= 1;
            }
        } while (true);
        return answer;
    }
}

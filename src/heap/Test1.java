package heap;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
//        int[] scoville = {1, 2, 9, 3, 10, 12};
//        int K = 7;

//        int[] scoville = {0, 0, 0, 0, 3};
//        int K = 4;

        int[] scoville = {1, 2};
        int K = 8;
        System.out.println("answer : " + solution(scoville, K));
    }

    static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : scoville) {
            queue.add(value);
        }
        while (queue.size() > 1 && queue.peek() < K) {
            int firstValue = queue.poll();
            int secondValue = queue.poll();
            int newScovillValue = firstValue + (secondValue * 2);
            queue.add(newScovillValue);
            answer++;
        }
        if (queue.size() >= 1 && queue.peek() < K) {
            answer = -1;
        }
        return answer;
    }
}

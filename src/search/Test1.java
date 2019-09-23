package search;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};
//        int[] answers = {2, 1, 2, 3, 2, 4, 2, 5, 2};
        int[] answers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int value : solution(answers)) {
            System.out.print(value + ",");
        }
    }

    static int[] solution(int[] answers) {
        int[] firstPersonWay = {1, 2, 3, 4, 5};
        int[] secondPersonWay = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPersonWay = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstPersonWayLength = firstPersonWay.length;
        int secondPersonWayLength = secondPersonWay.length;
        int thirdPersonWayLength = thirdPersonWay.length;
        int firstAnswerCount = 0;
        int secondAnswerCount = 0;
        int thirdAnswerCount = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == firstPersonWay[i % firstPersonWayLength]) firstAnswerCount++;
            if (answers[i] == secondPersonWay[i % secondPersonWayLength]) secondAnswerCount++;
            if (answers[i] == thirdPersonWay[i % thirdPersonWayLength]) thirdAnswerCount++;
        }
        int maxScore = Math.max(firstAnswerCount, Math.max(secondAnswerCount, thirdAnswerCount));
        List<Integer> list = new ArrayList<>();
        if (maxScore == firstAnswerCount) list.add(1);
        if (maxScore == secondAnswerCount) list.add(2);
        if (maxScore == thirdAnswerCount) list.add(3);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;

    }
}

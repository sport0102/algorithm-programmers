package binary;

import java.util.Arrays;

public class Test1  {
    public static void main(String[] args) {
//        int[] budgets = {120, 110, 140, 150};
//        int M = 485;

        int[] budgets = {5, 5, 5, 5, 15, 30};
        int M = 62;
        System.out.println(solution(budgets, M));
    }

    static int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        int answer = 0;
        if (budgets[0] >= M) {
            return M / budgets.length;
        }
        for (int i = 0; i < budgets.length; i++) {
            M -= budgets[i];
            if (answer > M) {
                break;
            }
            answer = M / (budgets.length - i - 1);
        }
        if (budgets[budgets.length - 1] <= answer) {
            answer = budgets[budgets.length - 1];
        }
        return answer;
    }
}


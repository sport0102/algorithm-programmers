package dynamic;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
//        int N = 5;
        int N = 6;
        System.out.println(solution(N));
    }

    static long solution(int N) {
        if (N == 1) {
            return 4;
        }
        if (N == 2) {
            return 10;
        }
        ArrayList<Long> numberList = new ArrayList<>();
        numberList.add(1L);
        numberList.add(1L);
        for (int i = 2; i < N; i++) {
            numberList.add(numberList.get(i - 2) + numberList.get(i - 1));
        }
        return (numberList.get(N - 1) * 2) + ((numberList.get(N - 2) + numberList.get(N - 1)) * 2);
    }

}

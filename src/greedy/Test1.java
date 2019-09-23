package greedy;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reverse = {1, 3, 5};

//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reverse = {3};

//        int n = 3;
//        int[] lost = {3};
//        int[] reverse = {1};

        int n = 5;
        int[] lost = {1,3,4};
        int[] reverse = {3};
        System.out.println(solution(n, lost, reverse));
    }

    static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            boolean isMinus = true;
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == 0) continue;
                if (reserve[j] == lost[i] || reserve[j] - 1 == lost[i] || reserve[j] + 1 == lost[i]) {
                    reserve[j] = 0;
                    isMinus = false;
                    break;
                }
            }
            if (isMinus) n--;
        }
        return n;
    }
}

package heap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Test2 {
    public static void main(String[] args) {
//        int stock = 4;
//        int[] dates = {4, 10, 15};
//        int[] supplies = {20, 5, 10};
//        int k = 30;
        // 답 2

//        int stock = 10;
//        int[] dates = {5, 10};
//        int[] supplies = {1, 100};
//        int k = 100;
        // 답 1

//        int stock = 4;
//        int[] dates = {1, 2, 3,4};
//        int[] supplies = {10, 40, 20,30};
//        int k = 100;
//        닶 4

        int stock = 4;
        int[] dates = {1, 2, 3, 4};
        int[] supplies = {10, 40, 30, 20};
        int k = 100;
//        닶 4

//        int stock = 2;
//        int[] dates = {1};
//        int[] supplies = {10};
//        int k = 10;
//        답 1
        System.out.println(solution(stock, dates, supplies, k));
    }

    static int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> pqSupplies = new PriorityQueue<>(Comparator.reverseOrder());
        int spIdx = 0;
        int cnt = 0;
        for (int day = 0; day < k; day++) {
            System.out.println("day : "+day);
            if (spIdx < dates.length && day >= dates[spIdx]) {
                pqSupplies.add(supplies[spIdx]);
                System.out.println("supplies[spIdx] : "+supplies[spIdx]);
                spIdx++;
                System.out.println("spIdx : "+spIdx);
            }
            if (stock <= 0) {
                stock += pqSupplies.remove();
                System.out.println("0 stock : "+stock);
                cnt++;
            }
            stock--;
            System.out.println("stock : "+stock);
        }

        return cnt;
    }

//    static int solution(int stock, int[] dates, int[] supplies, int k) {
//        int supplyCount = 0;
//        int day = 1;
//        LinkedList<Integer> dateQueue = new LinkedList<>();
//        LinkedList<Integer> supplyQueue = new LinkedList<>();
//        for (int i = 0; i < dates.length; i++) {
//            dateQueue.add(dates[i]);
//            supplyQueue.add(supplies[i]);
//        }
//        int supplyDate = 0;
//        int supplyQuantity = 0;
//        System.out.println("k : " + k);
//        while (day < k) {
//            System.out.println("day : " + day);
//            stock--;
//            System.out.println("stock : " + stock);
//            if (stock == 0) {
//                while (day > supplyDate && !dateQueue.isEmpty()) {
//                    supplyDate = dateQueue.poll();
//                    supplyQuantity = supplyQueue.poll();
//                }
//                System.out.println("supplyQuantity : " + supplyQuantity);
//                stock += supplyQuantity;
//                supplyCount++;
//                System.out.println("supplyCount : " + supplyCount);
//            }
//            day++;
//        }
//        return supplyCount;
//    }

}

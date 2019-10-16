package stack;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        // 8
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7, 4, 5, 6};

        // 101
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};

        // 110
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        System.out.println("answer : " + solution(bridge_length, weight, truck_weights));
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<TruckInfo> truckStack = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            truckStack.add(new TruckInfo(truckWeight));
        }
        int nowWeight = 0;
        int truckWeight;
        Queue<TruckInfo> nowTruckList = new LinkedList<>();
        while (!truckStack.isEmpty()) {
            if (weight >= nowWeight + truckStack.peek().weight) {
                TruckInfo truck = truckStack.poll();
                truckWeight = truck.weight;
                nowTruckList.add(truck);
                nowWeight += truckWeight;
            }
            if (truckStack.isEmpty()) {
                time += bridge_length + 1;
                break;
            }
            Queue<TruckInfo> modifiedTruckList = new LinkedList<>();
            while (!nowTruckList.isEmpty()) {
                TruckInfo truckInfo = nowTruckList.poll();
                truckInfo.time++;
                if (truckInfo.time < bridge_length) {
                    modifiedTruckList.add(truckInfo);
                    continue;
                }
                nowWeight -= truckInfo.weight;
            }
            time++;
            nowTruckList = modifiedTruckList;
        }
        return time;
    }

    static class TruckInfo {
        int weight;
        int time;

        TruckInfo(int weight) {
            this.weight = weight;
            time = 0;
        }

        @Override
        public String toString() {
            return "weight : " + weight + "/ time : " + time;
        }
    }

}

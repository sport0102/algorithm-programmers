package graph;

import java.util.LinkedList;

public class Test2 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(n, results));
    }

    static public int solution(int n, int[][] results) {
        int answer = 0;
        Graph graph = new Graph(n, results);
        for (int i = 1; i <= n; i++) {
            if (graph.bfs(i)) {
                answer++;
            }
            graph.initVisitMap();
            graph.initCount();
        }
        return answer;
    }

    static class Graph {
        Node[] nodes;
        int winnerCount = 0;
        int looserCount = 0;

        public Graph(int n, int[][] results) {
            nodes = new Node[n + 1];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node();
            }
            for (int[] result : results) {
                int winnerIndex = result[0];
                int looserIndex = result[1];
                if (!nodes[winnerIndex].winnerList.contains(looserIndex)) {
                    nodes[winnerIndex].winnerList.add(looserIndex);
                }
                if (!nodes[looserIndex].looserList.contains(winnerIndex)) {
                    nodes[looserIndex].looserList.add(winnerIndex);
                }
            }
            for (Node node : nodes) {
                System.out.println(node.toString());
            }
            initVisitMap();
        }

        public void initVisitMap() {
            for (Node node : nodes) {
                node.isVisited = false;
            }
        }

        public void initCount() {
            winnerCount = 0;
            looserCount = 0;
        }

        public boolean bfs(int n) {
            return bfs(nodes[n]);
        }

        private boolean bfs(Node node) {
            node.isVisited = true;
            searchWinnerCount(node);
            initVisitMap();
            searchLooserCount(node);
            return winnerCount + looserCount == nodes.length - 2;
        }

        private void searchWinnerCount(Node node) {
            LinkedList<Integer> list = (LinkedList<Integer>) node.winnerList.clone();
            while (!list.isEmpty()) {
                int index = list.poll();
                if (!nodes[index].isVisited) {
                    nodes[index].isVisited = true;
                    winnerCount++;
                    searchWinnerCount(nodes[index]);
                }
            }
        }

        private void searchLooserCount(Node node) {
            LinkedList<Integer> list = (LinkedList<Integer>) node.looserList.clone();
            while (!list.isEmpty()) {
                int index = list.poll();
                if (!nodes[index].isVisited) {
                    nodes[index].isVisited = true;
                    looserCount++;
                    searchLooserCount(nodes[index]);
                }
            }
        }

        class Node {
            LinkedList<Integer> winnerList;
            LinkedList<Integer> looserList;
            Boolean isVisited;

            public Node() {
                winnerList = new LinkedList<>();
                looserList = new LinkedList<>();
            }

            @Override
            public String toString() {
                StringBuilder value = new StringBuilder("winner list : ");
                for (Integer i : winnerList) {
                    value.append(i).append(",");
                }
                value.append("looser list : ");
                for (Integer i : looserList) {
                    value.append(i).append(",");
                }
                return value.toString();
            }
        }
    }
}

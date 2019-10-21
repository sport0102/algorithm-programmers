package kakao;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    static List<String> solution() {
//        List<String> s = new ArrayList<>();
//        List<String> t = new ArrayList<>();
//        s.add("aaa");
//        t.add("aab");

        List<String> s = new ArrayList<>();
        List<String> t = new ArrayList<>();
        s.add("accc");
        t.add("abbb");
        s.add("aaa");
        t.add("aab");
        s.add("aaacccc");
        t.add("aabdddd");


        int listSize = s.size();
        List<String> answerList = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        String word;
        Iterator<Character> iterator;
        int differ;
        Character mapKey;
        String answer;
        for (int i = 0; i < listSize; i++) {
            sMap.clear();
            tMap.clear();
            word = s.get(i);
            char c;
            for (int j = 0; j < word.length(); j++) {
                c = word.charAt(j);
                if (!sMap.containsKey(c)) {
                    sMap.put(c, 1);
                } else {
                    sMap.put(c, sMap.get(c) + 1);
                }
            }
            word = t.get(i);
            for (int j = 0; j < word.length(); j++) {
                c = word.charAt(j);
                if (!tMap.containsKey(c)) {
                    tMap.put(c, 1);
                } else {
                    tMap.put(c, tMap.get(c) + 1);
                }
            }

            iterator = sMap.keySet().iterator();
            answer = "YES";
            while (iterator.hasNext()) {
                mapKey = iterator.next();
                if (tMap.get(mapKey) == null) {
                    tMap.put(mapKey, 0);
                }
                differ = Math.abs(sMap.get(mapKey) - tMap.get(mapKey));
                tMap.remove(mapKey);
                if (differ > 3) {
                    answer = "NO";
                    break;
                }
            }

            iterator = tMap.keySet().iterator();
            while (iterator.hasNext()) {
                mapKey = iterator.next();
                if (sMap.get(mapKey) == null) {
                    sMap.put(mapKey, 0);
                }
                differ = Math.abs(sMap.get(mapKey) - tMap.get(mapKey));
                if (differ > 3) {
                    answer = "NO";
                    break;
                }
            }
            answerList.add(answer);
        }
        return answerList;
    }
}

package hash;

import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden", "leo", "leo"};
        String[] completion = {"eden", "kiki", "leo", "leo"};
        System.out.println("answer : " + solution(participant, completion));
    }


    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap checkMap = new HashMap<String, Integer>();
        for (String value : completion) {
            if (checkMap.get(value) == null) {
                checkMap.put(value, 0);
            } else {
                checkMap.put(value, (Integer) checkMap.get(value) + 1);
            }
        }
        for (String value : participant) {
            if (checkMap.get(value) == null) {
                answer = value;
                break;
            }
            if ((Integer) checkMap.get(value) == 0) {
                checkMap.remove(value);
                continue;
            }
            checkMap.put(value, (Integer) checkMap.get(value) - 1);
        }
        return answer;
    }
}
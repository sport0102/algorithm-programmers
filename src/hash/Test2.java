package hash;

import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {
//        String[] phoneBook = {"119", "97674223", "1195524421"};
//        String[] phoneBook = {"123", "456", "789"};
        String[] phoneBook = {"12", "123", "1235", "567", "88"};
        System.out.println(solution(phoneBook));
    }

    static boolean solution(String[] phoneBook) {
        boolean answer = true;
        for (int i = 0; i < phoneBook.length; i++) {
            for (int j = 0; j < phoneBook.length; j++) {
                if (i == j) {
                    continue;
                }
                if (phoneBook[j].startsWith(phoneBook[i])) {
                    answer = false;
                    break;
                }
            }
            if (!answer) break;
        }
        return answer;
    }
}

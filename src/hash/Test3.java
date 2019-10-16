package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Test3 {
    public static void main(String[] args) {
        //5
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        //3
//        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes));
    }

    static public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> clothMap = new HashMap<>();
        String type;
        String item;
        ArrayList clothArrayList;
        for (String[] cloth : clothes) {
            item = cloth[0];
            type = cloth[1];
            if (clothMap.get(type) == null) {
                clothArrayList = new ArrayList<String>();
            } else {
                clothArrayList = clothMap.get(type);
            }
            clothArrayList.add(item);
            clothMap.put(type, clothArrayList);
        }
        Iterator<String> mapIterator = clothMap.keySet().iterator();
        while (mapIterator.hasNext()) {
            String key = mapIterator.next();
            answer *= clothMap.get(key).size() + 1;
        }
        answer -= 1;
        return answer;
    }
}

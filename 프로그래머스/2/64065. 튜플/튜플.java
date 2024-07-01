import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String s) {
        String replace1 = s.replace("{", "");
        String replace2 = replace1.replace("}", "");
        String[] numbers = replace2.split(",");

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (String num : numbers) {
            int n = Integer.parseInt(num);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Stream<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

        sorted.forEach(entry -> answer.add(entry.getKey()));

        //System.out.println(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
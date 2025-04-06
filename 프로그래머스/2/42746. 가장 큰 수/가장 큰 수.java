import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList();
        for (int n : numbers) list.add(String.valueOf(n));
        
        list.sort((o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        });
        
        StringBuilder answer = new StringBuilder();
        for (String s : list) answer.append(s);
        
        return answer.charAt(0) == '0' ? "0" : answer.toString();
    }
}

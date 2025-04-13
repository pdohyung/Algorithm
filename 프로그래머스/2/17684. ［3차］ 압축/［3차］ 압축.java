import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> d = new ArrayList<>();
        d.add("");
        String line = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char c : line.toCharArray()) d.add(String.valueOf(c));
        
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int i = 0;
        
        while (true) {
            while (d.contains(sb.toString())) {
                if (i == msg.length()) break;
                char c = msg.charAt(i++);
                sb.append(c);
            }
            
            StringBuilder next = new StringBuilder().append(sb);
            next.deleteCharAt(sb.length() - 1);
            
            if (i != msg.length()) {
                result.add(d.indexOf(next.toString()));
                d.add(sb.toString());
                sb.delete(0, next.length());
            }
            
            if (i == msg.length()) {
                if (d.contains(sb.toString())) {
                    result.add(d.indexOf(sb.toString()));    
                } else {
                    result.add(d.indexOf(next.toString()));
                    sb.delete(0, next.length());
                    result.add(d.indexOf(sb.toString()));
                }
                
                break;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int r = 0; r < answer.length; r++) answer[r] = result.get(r);
        return answer;
    }
}

class Solution {
    public int solution(String name) {
        char[] chars = name.toCharArray();
        int length = chars.length;
        int answer = 0;
        int move = length - 1;
        
        for (int i = 0; i < length; i++) {
            char now = chars[i];
            answer += Math.min(now - 'A', 'Z' - now + 1);
            int next = i + 1;
            
            while (next < length && chars[next] == 'A') next++;
            
            move = Math.min(move, i * 2 + length - next);
            move = Math.min(move, (length - next) * 2 + i);
        }
        
        return answer + move;
    }
}
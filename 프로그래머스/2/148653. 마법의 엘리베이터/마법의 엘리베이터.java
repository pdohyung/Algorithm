class Solution {
    public int solution(int storey) {
        while (storey % 10 == 0) {
            storey /= 10;
        }
        
        int cnt = 1;
        int s = 0;
        int answer = 0;
        
        while (storey > 0) {
            int q = storey / 10;
            int m = storey % 10;
            
            if (m > 5 || (m == 5 && (q % 10) >= 5)) {
                q += 1;
                answer += 10 - m;
            }
            else s += cnt * m;
            
            storey = q;
            cnt *= 10;
        }
        
        while (s > 0) {
            answer += s % 10;
            s /= 10;
        }
        
        return answer;
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCnt = Integer.bitCount(n);
        int tCnt = 0;
        
        while (true) {
            n++;
            tCnt = Integer.bitCount(n);
            
            if (nCnt == tCnt) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}

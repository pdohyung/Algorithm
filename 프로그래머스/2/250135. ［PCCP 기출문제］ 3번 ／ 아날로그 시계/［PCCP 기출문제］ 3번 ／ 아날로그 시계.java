class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 초침이 시침, 분침과 겹칠 때마다 알람이 울리는데, 특정 시간 동안 알림이 울린 횟수를 리턴
        // 초침, 분침은 59분에서 00분로 갈 때, 겹치지 않음, 24가지
        // 초침, 시침은 11시 59분에서 12시, 23시 59분에서 00시로 갈 떄, 겹치지 않음, 2가지
        // 12시와 00시에는 초침, 분침, 시침이 겹치므로 1가지 경우로 생각함, 2가지
        // 1440 * 2 - 24 - 2 - 2 = 2852
        int start = h1 * 60 * 60 + m1 * 60 + s1;
        int end = h2 * 60 * 60 + m2 * 60 + s2;
        int answer = count(end) - count(start);
        
        if (start * 59 % 3600 == 0 || start * 719 % 43200 == 0) {
            answer++;
        }
        
        return answer;
    }
    
    int count(int s) {
        int mCnt = s * 59 / 3600;
        int hCnt = s * 719 / 43200;
        
        return mCnt + hCnt - (43200 <= s ? 2 : 1); 
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        // 노란색과 갈색으로 색칠된 격자의 개수는 기억, 하지만 전체 카펫 크기는 기억하지 못했음
        // 가로 길이는 세로와 같거나, 세로보다 길다, 가로 >= 세로
        int[] answer = new int[2];
        
        for (int i = 3; i <= brown / 2; i++) {
            for (int j = i; j <= brown / 2; j++) {
                int n = i * 2 + j * 2 - 4;
                int m = i * j - n;
                
                if (brown == n && yellow == m) {
                    answer[0] = j;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}

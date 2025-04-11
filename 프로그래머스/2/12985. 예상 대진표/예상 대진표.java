class Solution{
    public int solution(int n, int a, int b){
        int cnt = 1;
        
        while (true) {
            if (a < b && b - a == 1 && (a + 1) % 2 == 0) break;
            if (a > b && a - b == 1 && (b + 1) % 2 == 0) break;
            
            n /= 2;
            cnt++;
            
            if (a % 2 == 0) a /= 2;
            else a = (a + 1) / 2;
            
            if (b % 2 == 0) b /= 2;
            else b = (b + 1) / 2;
        }

        return cnt;
    }
}

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String kNum = Integer.toString(n, k);
        String[] numbers = kNum.split("0");
        
        for(String s : numbers) {
            if(s.equals("")) {
                continue;
            }
            
            long num = Long.parseLong(s);
            
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 소수인지 검사, 1과 같거나 작은 경우 / 주어진 수가 나눠지는 수가 있는 경우
    static boolean isPrime(long num) {
        if(num <= 1) {
            return false;
        }
        
        // 제곱근까지만 반복, 본인으로 나눠지는 경우는 제외함.
        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int start = 1;
        int end = Integer.MAX_VALUE;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if (canCross(stones, k, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }
    
    boolean canCross(int[] stones, int k, int people) {
        int cnt = 0;
        
        for (int stone : stones) {
            if (stone < people) cnt++;
            else cnt = 0;
            
            if (cnt >= k) return false;
        }
        
        return true;
    }
}

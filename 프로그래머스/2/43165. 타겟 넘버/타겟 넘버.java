class Solution {
    
    int answer, N, T;
    int[] A;
    
    public int solution(int[] numbers, int target) {
        // n개의 음이 아닌 정수들이 있고, 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버 만들기
        // 거의 2^20이기 때문에 1백만 정도의 시간복잡도
        N = numbers.length;
        A = numbers;
        T = target;
        
        answer = 0;
        dfs(0, 0);
        
        return answer;
    }
    
    void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == T) {
               answer++; 
            }
            return;
        }
        
        dfs(depth + 1, sum + A[depth]);
        dfs(depth + 1, sum - A[depth]);
    }
}

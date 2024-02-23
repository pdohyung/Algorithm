class Solution {
    static int answer;
    static int end;
    static int targetNumber;
    static int[] inputNumbers;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        end = numbers.length;
        targetNumber = target;
        inputNumbers = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int res, int depth) {
        if(depth == end) {
            if (res == targetNumber) {
                answer++;
            }
            return;
        }
        
         dfs(res + inputNumbers[depth], depth + 1);
         dfs(res - inputNumbers[depth], depth + 1);
    }
}
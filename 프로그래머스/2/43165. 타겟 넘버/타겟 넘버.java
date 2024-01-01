class Solution {
    static int answer;

    public static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    private static void dfs(int sum, int n, int[] numbers, int target) {
        if (n == numbers.length && sum == target) {
            answer++;
            return;
        }

        if (n >= numbers.length) {
            return;
        }

        dfs(sum + numbers[n], n + 1, numbers, target);
        dfs(sum - numbers[n], n + 1, numbers, target);
    }
}
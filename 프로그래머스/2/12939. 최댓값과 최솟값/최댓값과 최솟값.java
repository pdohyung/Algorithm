class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        int[] numbers = new int[split.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(min).append(" ").append(max);
        
        return answer.toString();
    }
}

import java.util.Arrays;
class Solution {
   public int[] solution(int[] array, int[][] commands){
		int[] answer = new int[commands.length];

		for(int i = 0; i < commands.length; i++){
			answer[i] = cutArray(array, commands[i]);
		}
		return answer;
	}

	private int cutArray(int[] array, int[] commands){
		return Arrays.stream(array)
			.skip(commands[0] - 1)
			.limit(commands[1] - commands[0] + 1)
			.sorted()
			.skip(commands[2] - 1)
			.findFirst()
			.orElse(-1);
	}
}
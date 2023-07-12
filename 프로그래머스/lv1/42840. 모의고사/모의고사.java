import java.util.stream.IntStream;

public class Solution {
	private static final int[][] RULES = {
		{1, 2, 3, 4, 5},
		{2, 1, 2, 3, 2, 4, 2 ,5},
		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};

	private int getPick(int person, int problem){
		int[] rule = RULES[person];
		int index = problem % rule.length;
		return rule[index];
	}

	public int[] solution(int[] answers) {
		int[] currect = new int[3];
		int max = 0;

		for (int problem = 0; problem < answers.length; problem++) {
			int answer = answers[problem];
			for (int i = 0; i < 3; i++) {
				int pick = getPick(i, problem);
				if (answer == pick) {
					if (++currect[i] > max)
						max = currect[i];
				}
			}
		}
		
		int finalMax = max;
		return IntStream.range(0, 3)
			.filter(i -> currect[i] == finalMax)
			.map(i -> i + 1)
			.toArray();
	}
}
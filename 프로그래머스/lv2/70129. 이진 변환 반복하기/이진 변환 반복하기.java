public class Solution {
	public int[] solution(String s){
		int loop = 0;
		int remove = 0;

		while(!s.equals("1")){
			loop += 1;
			remove += countZero(s);
			
			int onesLen = s.length() - countZero(s);
			s = Integer.toString(onesLen, 2);
		}

		return new int[] {loop, remove};
	}

	private int countZero(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '0')
				count++;
		}
		return count;
	}
}
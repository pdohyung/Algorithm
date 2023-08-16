import java.util.*;
class Solution {
    public int solution(String s) {
		char[] str = s.toCharArray();
		int cnt = 0;

		for (int i = 0; i < str.length; i++) {
			if (isCorrect(str, i)){
				cnt++;
			}
		}
		return cnt;
	}

	private static boolean isCorrect(char[] s, int offset){
		Stack<Character> chars = new Stack<>();
		for(int i = 0; i < s.length; i++){
			char c = s[(offset + i) % s.length];
			switch (c) {
				case '(': chars.push(')');
					break;
				case '[': chars.push(']');
					break;
				case '{': chars.push('}');
					break;
				case ')':
				case ']':
				case '}':
					if (chars.isEmpty()) return false;
					if (chars.pop() != c) return false;
					break;
			}
		}
			return chars.isEmpty();
	}
}
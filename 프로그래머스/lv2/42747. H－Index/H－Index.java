import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        
        
		Arrays.sort(citations);
		for(int i = citations.length; i >= 1; i--){
			if(isVaild(citations, i)) return i;
		}
		return 0;
    }
    
    public boolean isVaild(int[] citations, int h){
		int index = citations.length - h;
		return citations[index] >= h;
	}
}
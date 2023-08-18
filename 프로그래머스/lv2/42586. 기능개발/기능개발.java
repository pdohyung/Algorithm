import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		int days = 0;
		int cnt = 0;

		IntStream.range(0, progresses.length)
			.boxed()
			.forEach(i -> q.add(i));

		while(!q.isEmpty()){

			int index = q.poll();
			int expiration = (int) Math.ceil( (double) (100 - progresses[index]) / speeds[index]);

			if(expiration > days){
				if(days != 0){
					result.add(cnt);
					cnt = 0;
				}
				days = expiration;
			}
			cnt++;
		}

		result.add(cnt);
		return result.stream()
			.mapToInt(Integer::intValue)
			.toArray();
    }
}
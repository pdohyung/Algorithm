import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
 
class Solution {
    
    static HashMap<String, List<Integer>> map;

	public int[] solution(String[] info, String[] query){
		int[] answer = new int[query.length];

		map = new HashMap<String, List<Integer>>();

		for(int i = 0; i < info.length; i++){
			String[] p = info[i].split(" ");
			makeQuery(p, "", 0);
		}

		for(String key : map.keySet())
			Collections.sort((map.get(key)));

		for(int i = 0; i < query.length; i++){
			query[i] = query[i].replaceAll(" and ", "");
			String[] q = query[i].split(" ");
			answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
		}
		return answer;
	}

	private static int binarySearch(String key, int score){
		List<Integer> scores = map.get(key);
		int start = 0;
		int end = scores.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (scores.get(mid) < score)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return scores.size() - start;
	}

	private static void makeQuery(String[] p, String s, int cnt){
		if(cnt == 4){
			if(!map.containsKey(s)){
				List<Integer> list = new ArrayList<>();
				map.put(s, list);
			}
			map.get(s).add(Integer.parseInt(p[4]));
			return;
		}

		makeQuery(p, s + "-", cnt + 1);
		makeQuery(p, s + p[cnt], cnt + 1);
	}
}
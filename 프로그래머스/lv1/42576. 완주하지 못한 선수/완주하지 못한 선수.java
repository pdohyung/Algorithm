import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
       HashMap<String, Integer> names = new HashMap<>();

		for(String name : participant){
			names.put(name, names.getOrDefault(name, 0) + 1);
		}

		for (String name : completion) {
			names.put(name, names.get(name) - 1);
		}

		for(String name : names.keySet()){
			if(names.get(name) > 0)
				return name;
		}
		return null;
    }
}
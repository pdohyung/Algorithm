import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pokemons = new HashSet<Integer>();
        for (int i : nums) {
            pokemons.add(i);
        }
        if (pokemons.size() > (nums.length / 2)) {
            return nums.length / 2;
        }
        return pokemons.size();
    }
}
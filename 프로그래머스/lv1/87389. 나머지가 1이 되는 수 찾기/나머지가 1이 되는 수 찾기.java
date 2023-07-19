import java.util.stream.IntStream;
class Solution {
    public int solution(int n) {
        return IntStream.iterate(2, x -> x + 1)
			.filter(x -> n % x == 1)
			.findFirst()
			.getAsInt();
    }
}
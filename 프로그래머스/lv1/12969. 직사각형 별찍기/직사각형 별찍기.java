import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		IntStream.range(0, b)
			.mapToObj(i -> IntStream.range(0, a)
				.mapToObj(j -> "*")
				.collect(Collectors.joining()))
			.forEach(System.out::println);
    }
}
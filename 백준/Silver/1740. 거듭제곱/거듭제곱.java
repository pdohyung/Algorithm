import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		Queue<Long> q = new LinkedList<>();

		while (N != 0) {
			q.add(N % 2);
			N /= 2;
		}

		long ans = 0;
		long mul = 1;

		while (!q.isEmpty()) {
			ans += q.poll() * mul;
			mul *= 3;
		}

		System.out.println(ans);
	}
}
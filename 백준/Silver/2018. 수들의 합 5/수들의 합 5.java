import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = i; j <= N; j++) {
				sum += j;
				if (sum > N)
					break;
				else if (sum == N) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());

			for (int j = 2; j <= N; j++) {
				int cnt = 0;
				while (N % j == 0) {
					N /= j;
					cnt++;
				}

				if (cnt != 0) {
					sb.append(j + " " + cnt + "\n");
				}
			}

			System.out.print(sb.toString());
		}
	}
}
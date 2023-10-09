import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		solve(n, c);
	}

	static void solve(int n, int c) {
		int[][] arr = new int[n][n];
		int value = 1, move = 1;
		int x = n / 2, y = n / 2;

		while (true) {
			for (int i = 0; i < move; i++) {
				arr[y--][x] = value++;
			}
			if (value == n * n + 1)
				break;

			for (int i = 0; i < move; i++) {
				arr[y][x++] = value++;
			}
			move++;

			for (int i = 0; i < move; i++) {
				arr[y++][x] = value++;
			}

			for (int i = 0; i < move; i++) {
				arr[y][x--] = value++;
			}
			move++;
		}

		StringBuilder sb = new StringBuilder();
		int cx = 0, cy = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c == arr[i][j]) {
					cy = i + 1;
					cx = j + 1;
				}
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append(cy + " " + cx);
		System.out.println(sb.toString());
	}
}
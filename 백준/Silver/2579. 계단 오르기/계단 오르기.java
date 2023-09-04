import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] S = new int[301];
	static int[][] D = new int[301][3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 1; i <= N; i++){
			S[i] = Integer.parseInt(br.readLine());
		}
		D[1][1] = S[1];
		D[1][2] = 0;
		D[2][1] = S[2];
		D[2][2] = S[1] + S[2];

		for(int i = 3; i <= N; i++){
			D[i][1] = Math.max(D[i - 2][1], D[i - 2][2]) + S[i];
			D[i][2] = D[i - 1][1] + S[i];
		}
		System.out.println(Math.max(D[N][1], D[N][2]));
	}
}
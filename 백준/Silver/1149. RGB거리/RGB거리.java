import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] cost = new int[1002][4];
	static int[] R = new int[1002];
	static int[] G = new int[1002];
	static int[] B = new int[1002];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 1; i <= N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}

		cost[1][0] = R[1];
		cost[1][1] = G[1];
		cost[1][2] = B[1];

		for(int i = 2; i<= N; i++){
			cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + R[i];
			cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + G[i];
			cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + B[i];
		}

		System.out.println(Math.min(Math.min(cost[N][0], cost[N][1]), cost[N][2]));
	}
}
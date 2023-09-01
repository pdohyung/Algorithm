import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];

		for(int i = 0; i < N; i++){
			numbers[i] = Integer.parseInt(st2.nextToken());
		}

		int res = Integer.MIN_VALUE;

		for(int i = 0; i < N; i++){
			for(int j = i + 1; j < N; j++){
				for(int k = j + 1; k < N; k++){
					int sum = numbers[i] + numbers[j] + numbers[k];
					if(sum == M) {
						System.out.println(sum);
						return;
					}
					else if (sum < M)
						res = Math.max(res, sum);
				}
			}
		}
		System.out.println(res);
	}
}
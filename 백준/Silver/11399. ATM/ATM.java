import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] mins = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++){
			mins[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(mins);
		
		long res = 0;
		long sum = 0;
		
		for(int i = 0; i < N; i++){
			sum += mins[i];
			res += sum;
		}
		System.out.println(res);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int picture[][] = new int[101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());

		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st2.nextToken());
			int y1 = Integer.parseInt(st2.nextToken());
			int x2 = Integer.parseInt(st2.nextToken());
			int y2 = Integer.parseInt(st2.nextToken());
			for(int j = x1; j <= x2; j++) {
				for(int k = y1; k <= y2 ; k++) {
					picture[j][k] += 1;
				}
			}
		}
		
		int res = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(picture[i][j] > M) res++;
			}
		}
		System.out.println(res);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] point = new int[2];
		int radius = H / 2;
		double distance = 0;
		int res = 0;
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			point[0] = Integer.parseInt(st.nextToken()) - X;
			point[1] = Integer.parseInt(st.nextToken()) - Y;
			if (point[0] >= 0 && point[0] <= W && point[1] >= 0 && point[1] <= H) {
				res++;
				continue;
			}

			distance = Math.pow(Math.abs(point[0]), 2) + Math.pow(Math.abs(point[1] - radius), 2);
			if (radius * radius >= distance) {
				res++;
				continue;
			}

			distance = Math.pow(Math.abs(point[0] - W), 2) + Math.pow(Math.abs(point[1] - radius), 2);
			if (radius * radius >= distance) {
				res++;
				continue;
			}
		}
		System.out.println(res);
	}
}
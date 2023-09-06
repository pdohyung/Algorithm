import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());

		int[] arr1 = new int[N];
		int[] arr2 = new int[M];

		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr1[i] = Integer.parseInt(st2.nextToken());
		}

		StringTokenizer st3 = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++){
			arr2[i] = Integer.parseInt(st3.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		int i=0;
		int j=0;
		while(i < N && j < M) {
			if(arr1[i]<arr2[j]) {
				sb.append(arr1[i++]+" ");
			}else {
				sb.append(arr2[j++]+" ");
			}
		}
		while(i < N) {
			sb.append(arr1[i++] + " ");
		}
		while(j < M) {
			sb.append(arr2[j++] + " ");
		}
		System.out.println(sb.toString());
	}
}
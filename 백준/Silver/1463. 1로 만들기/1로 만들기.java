import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] mem = new int[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		mem[1] = 0;
		for(int i = 2; i <= N; i++){
			mem[i] = mem[i - 1] + 1;
			if(i % 2 == 0) mem[i] = Math.min(mem[i], mem[i / 2] + 1);
			if(i % 3 == 0) mem[i] = Math.min(mem[i], mem[i / 3] + 1);
		}
		System.out.println(mem[N]);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] mem = new int[13];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		mem[1] = 1;
		mem[2] = 2;
		mem[3] = 4;

		for(int j = 4; j <= 11; j++) {
			mem[j] = mem[j - 3] + mem[j - 2] + mem[j - 1];
		}
		
		for(int i = 0 ; i < T; i++){
			int N = Integer.parseInt(br.readLine());
			System.out.println(mem[N]);
		}
	}
}
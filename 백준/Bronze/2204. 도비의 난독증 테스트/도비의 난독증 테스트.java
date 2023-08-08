import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int cnt;
	static String list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			cnt = Integer.parseInt(br.readLine());

			if(cnt == 0)
				break;

			list = new String[cnt];

			for(int i = 0; i < cnt; i++){
				list[i] = br.readLine();
			}

			Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

			System.out.println(list[0]);
		}
	}
}

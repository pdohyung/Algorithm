import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		String[] names = new String[N + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			map.put(name, i);
			names[i] = name;
		}

		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(isNumber(s)){
				sb.append(names[Integer.parseInt(s)]);
			}else {
				sb.append(map.get(s));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean isNumber(String s){
		try {
			Double.parseDouble(s);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
}
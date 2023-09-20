import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String>[] arr = new ArrayList[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<>();
			String cur = br.readLine();
			for (int j = 0; j < cur.length(); j++)
				arr[i].add(cur.substring(j) + cur.substring(0, j));

			boolean check = true;
			for (int j = 0; check && j <= i-1; j++) {
				for (int k = 0; check && k < arr[j].size(); k++) {
					if (cur.equals(arr[j].get(k))) check = false;
				}
			}
			if (check)
				cnt++;
		}
		System.out.println(cnt);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static boolean[] visited;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i <= N; i++)
			tree.add(new ArrayList<>());

		for(int i = 0; i < N - 1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			tree.get(num1).add(num2);
			tree.get(num2).add(num1);
		}

		visited = new boolean[N + 1];
		parents = new int[N + 1];

		dfs(1);

		for (int i = 2; i< parents.length; i++) {
			System.out.println(parents[i]);
		}
	}
	static void dfs(int node) {
		visited[node] = true;

		for (int v : tree.get(node)) {
			if (!visited[v]) {
				dfs(v);
				parents[v] = node;
			}
		}
	}
}
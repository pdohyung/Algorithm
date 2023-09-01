import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        int cnt = 0;
        StringJoiner sj = new StringJoiner(", ");

        while (!q.isEmpty()){
            int val = q.poll();
            cnt++;
            if(cnt == K){
                cnt = 0;
                sj.add(Integer.toString(val));

            }
            else
                q.add(val);
        }
        System.out.println("<" + sj.toString() + ">");
    }
}
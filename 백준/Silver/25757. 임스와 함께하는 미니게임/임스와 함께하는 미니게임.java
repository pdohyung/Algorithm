import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        HashSet<String> friend = new HashSet<>();
        for (int i = 0; i < N; i++) friend.add(br.readLine());

        switch (type) {
            case "Y":
                System.out.print(friend.size());
                break;
            case "F":
                System.out.print(friend.size() / 2);
                break;
            case "O":
                System.out.print(friend.size() / 3);
                break;
            default:
                break;
        }
    }
}

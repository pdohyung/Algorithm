import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String res = br.readLine();

        System.out.println(poliomino(res));
    }
    private static String poliomino(String str) {
        String A = "AAAA", B = "BB";

        String ans = str.replaceAll("XXXX", A);
        ans = ans.replaceAll("XX", B);

        if (ans.contains("X"))
            ans = "-1";

        return ans;
    }
}
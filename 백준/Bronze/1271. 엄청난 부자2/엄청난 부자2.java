
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger divide = n.divide(m);
        BigInteger mod = n.mod(m);

        System.out.println(divide);
        System.out.println(mod);
    }
}

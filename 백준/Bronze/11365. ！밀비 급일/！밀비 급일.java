import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String sentence = br.readLine();

            if (sentence.equals("END")) {
                break;
            }

            sb.append(sentence);
            System.out.println(sb.reverse().toString());
            sb = new StringBuilder();
        }
    }
}
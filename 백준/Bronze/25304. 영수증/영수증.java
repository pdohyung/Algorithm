import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int estimateTotalPrice = 0;
        int totalPrice = Integer.parseInt(br.readLine());
        int numberOfTypes = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTypes; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            estimateTotalPrice += calculatePrice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        if (totalPrice != estimateTotalPrice) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }

    private static int calculatePrice(int price, int count) {
        return price * count;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputLength = Integer.parseInt(br.readLine());
        int length = 64;
        int cnt = 0;

        while(inputLength > 0){
            if(length > inputLength){
                length /= 2;
            }else {
                cnt++;
                inputLength -= length;
            }
        }
        System.out.println(cnt);
    }
}
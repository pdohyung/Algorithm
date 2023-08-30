import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] members = new String[N];

        for(int i = 0; i < N; i++){
            members[i] = br.readLine();
        }

       Arrays.stream(members)
           .sorted((member1, member2) -> {
               int age1 = Integer.parseInt(member1.split(" ")[0]);
               int age2 = Integer.parseInt(member2.split(" ")[0]);
               if(age1 == age2)
                   return 0;
               else if (age1 > age2)
                   return 1;
               else
                   return -1;
           }).forEach(System.out::println);
    }
}
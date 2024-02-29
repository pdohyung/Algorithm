import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static Map<String, Double> grade = Map.of(
            "A+", 4.5, "A0", 4.0,
            "B+", 3.5, "B0", 3.0,
            "C+", 2.5, "C0", 2.0,
            "D+", 1.5, "D0", 1.0,
            "F", 0.0);


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        double sumGrades = 0;
        double sumCredits = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String alpha = st.nextToken();

            if (alpha.equals("P")) {
                continue;
            }

            double gradeScore = grade.get(alpha);
            sumGrades += gradeScore * credit;
            sumCredits += credit;
        }

        System.out.println(sumGrades / sumCredits);
    }
}
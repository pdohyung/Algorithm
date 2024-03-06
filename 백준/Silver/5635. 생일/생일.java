import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static Map<LocalDate, String> birthdays;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        birthdays = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            LocalDate birthday = LocalDate.of(year, month, day);
            birthdays.put(birthday, name);
        }

        List<LocalDate> dates = birthdays.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(birthdays.get(dates.get(n - 1)));
        System.out.println(birthdays.get(dates.get(0)));
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> maxCntNumbers = new ArrayList<>();
        Map<Integer, Integer> numbersCnt = new HashMap<>();

        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxCnt = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
            numbersCnt.put(number, numbersCnt.getOrDefault(number, 0) + 1);
            min = Math.min(min, number);
            max = Math.max(max, number);
            sum += number;
        }

        for (int key : numbersCnt.keySet()) {
            maxCnt = Math.max(numbersCnt.get(key), maxCnt);
        }

        for (int key : numbersCnt.keySet()) {
            if (maxCnt == numbersCnt.get(key)) {
                maxCntNumbers.add(key);
            }
        }

        Collections.sort(maxCntNumbers);
        Collections.sort(numbers);
        System.out.println(Math.round(sum / N)); // 산술평균
        System.out.println(numbers.get(N / 2)); // 중앙값
        if (maxCntNumbers.size() > 1) { // 최빈값
            System.out.println(maxCntNumbers.get(1));
        } else {
            System.out.println(maxCntNumbers.get(0));
        }
        System.out.println(max - min); // 범위
        return;
    }

}
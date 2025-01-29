
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < T; i++) {
            char[] steps = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] numString = {};

            if (n != 0) {
                numString = line.replace("[", "").replace("]", "").split(",");
            }

            ArrayDeque<Integer> deque = new ArrayDeque<>();

//            System.out.println("라인 출력 = " + Arrays.toString(numString));

            for (String s : numString) {
                deque.add(Integer.parseInt(s));
            }

            int errorFlag = 0;
            int flag = 1; // 1 = 순방향, -1 = 역방향

            // 함수 수행
            for (char step : steps) {
                if (step == 'R') {
                    flag *= -1;
                } else if (step == 'D') {
                    if (deque.isEmpty()) {
                        errorFlag = 1;
                        break;
                    } else if (flag == 1) {
                        deque.removeFirst();
                    } else if (flag == -1) {
                        deque.removeLast();
                    }
                }
            }

            if (errorFlag == 1) {
                answer.append("error").append("\n");
                continue;
            }

            int length = deque.size();
//            System.out.println("길이 = " + length);

            answer.append("[");
            if (flag == 1) {
                for (int j = 0; j < length; j++) {
                    if (j != length - 1) {
                        answer.append(deque.removeFirst()).append(",");
                    } else {
                        answer.append(deque.removeFirst());
                    }
                }
            } else if (flag == -1) {
                for (int j = 0; j < length; j++) {
                    if (j != length - 1) {
                        answer.append(deque.removeLast()).append(",");
                    } else {
                        answer.append(deque.removeLast());
                    }
                }
            }
            answer.append("]").append("\n");
        }

        System.out.println(answer);
    }
}

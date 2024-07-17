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
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int minLen = Integer.parseInt(st.nextToken());
        Map<String, Integer> wordCnt = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < minLen) continue;
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(wordCnt.keySet());
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int countCompare = wordCnt.get(o2).compareTo(wordCnt.get(o1));
                if (countCompare != 0) {
                    return countCompare;
                }
                int lengthCompare = Integer.compare(o2.length(), o1.length());
                if (lengthCompare != 0) {
                    return lengthCompare;
                }
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i)).append("\n");
        }
        System.out.println(sb);
        return;
    }

}
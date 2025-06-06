
import java.util.*;
import java.io.*;

class Student {
    int num, cnt, start;

    public Student(int num, int cnt, int start) {
        this.num = num;
        this.cnt = cnt;
        this.start = start;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        // 학생들이 추천을 시작하기 전에 사진틀은 비어있음
        // 어떤 학생이 추천하면, 추천받은 학생은 사진틀에 반드시 게시
        // 비어있는 사진틀이 없으면, 추천 횟수가 가장 적은 학생의 사진을 삭제, 적은 학생이 두명이면, 오래된 사진을 제거
        // 현재 게시된 학생이 추천된 경우, 횟수만 증가
        // 사진틀에 게시된 사진이 삭제되는 경우, 추천 받은 횟수는 0으로 바뀜
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int[] A = new int[C];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Student> frame = new HashMap<>();

        for (int i = 0; i < C; i++) {
            int n = A[i];

            if (frame.containsKey(n)) {
                frame.get(n).cnt++;
            } else {
                if (frame.size() >= N) {
                    Student s = Collections.min(frame.values(), (a, b) -> {
                        if (a.cnt != b.cnt) return a.cnt - b.cnt;
                        return a.start - b.start;
                    });

                    frame.remove(s.num);
                }
                frame.put(n, new Student(n, 1, i));
            }
        }

        List<Integer> result = new ArrayList<>(frame.keySet());
        Collections.sort(result);
        for (int n : result) System.out.print(n + " ");
    }
}

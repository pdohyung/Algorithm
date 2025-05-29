import java.util.*;

class Solution {
    
    int N;
    boolean[][][] M;
    
    public int[][] solution(int n, int[][] build_frame) {
        // 기둥은 바닥 위에 있거나, 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에만 설치 가능
        // 보는 한쪽 끝 부분이 기둥 위에 있거나, 양쪽 끝 부분이 다른 보와 동시에 연결돼야 설치 가능
        // 보를 설치할 때, 양쪽 끝 부분이 다른 보와 연결되는 경우, 왼쪽 오른쪽 보가 먼저 설치돼야 함
        // 기둥과 보를 삭제 하는 경우도 있는데, 삭제한 후 남은 기둥과 보들 또한 위 규칙을 만족해야 함
        // 만약 작업을 수행한 결과가 조건을 만족하지 않는다면 해당 작업을 무시
        // 구조물 설치 입력은, 기둥 보는 오른쪽, 기둥은 위쪽 방향으로 설치, 삭제 진행
        N = n;
        M = new boolean[N + 2][N + 2][2];
        
        for (int[] bf : build_frame) {
            int x = bf[0];
            int y = bf[1];
            int type = bf[2]; // 0 = 기둥, 1 = 보
            int oper = bf[3]; // 0 = 삭제, 1 = 설치
            
            if (oper == 1) { // 설치
                if (canInstall(x, y, type)) {
                    M[x][y][type] = true;
                }
            } else { // 삭제
                M[x][y][type] = false;

                if (!isValidAll()) {
                    M[x][y][type] = true;
                }
            }
        }
        
        List<int[]> result = new ArrayList<>();
        
        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= N; y++) {
                for (int t = 0; t < 2; t++) {
                    if (M[x][y][t]) {
                        result.add(new int[]{x, y, t});
                    }
                }
            }
        }
        
        result.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        int[][] answer = new int[result.size()][3];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    boolean isValidAll() {
        for (int x = 0; x <= N; x++) {
            for (int y = 0; y <= N; y++) {
                for (int t = 0; t < 2; t++) {
                    if (M[x][y][t] && !canInstall(x, y, t)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    boolean canInstall(int x, int y, int type) {
        if (type == 0) { // 기둥
            if (y == 0) return true; // 바닥인 경우
            else if ((y > 0 && M[x][y - 1][0])) return true; // 다른 기둥의 위인 경우
            else if ((x > 0 && M[x - 1][y][1]) || M[x][y][1]) return true; // 보의 위인 경우
            return false;
        } else { // 보
            if (M[x][y - 1][0] || M[x + 1][y - 1][0]) return true; // 한쪽 끝이 기둥 위인 경우
            else if (x > 0 && M[x - 1][y][1] && M[x + 1][y][1]) return true; // 양쪽 끝이 보와 연결된 경우
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] place;
    static boolean[][] visited;
    static boolean check;

    public int[] solution(String[][] places){
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++){
            check = false;
            place = new char[5][5];
            for(int j = 0; j < 5; j++){
                place[j] = places[i][j].toCharArray();
            }

            for(int y = 0; y < 5; y++){
                for(int x = 0; x < 5; x++){
                    if(place[y][x] == 'P'){
                        visited = new boolean[5][5];
                        dfs(0, y, x);
                        if(check) break;
                    }
                }
            }
            if(check) answer[i] = 0;
            else answer[i] = 1;
        }
        return answer;
    }

    static void dfs(int d, int y, int x){
        if(d >= 2) return;
        visited[y][x] = true;
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(ny < 0 || ny > 4 || nx < 0 || nx > 4) continue;
            if(visited[ny][nx] || place[ny][nx] == 'X') continue;
            visited[ny][nx] = true;

            if(place[ny][nx] == 'P'){
                check = true;
                return;
            }
            else if(place[ny][nx] == 'O')
                dfs(d + 1, ny, nx);
        }
    }
}
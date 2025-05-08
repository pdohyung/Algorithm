
import java.util.*;
import java.io.*;

class Player {
    String name;
    int level;

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
    }
}

class Room {
    int low, high;
    List<Player> players;

    boolean isLower(int m) {
        return players.size() < m;
    }

    public Room(int low, int high, List<Player> players) {
        this.low = low;
        this.high = high;
        this.players = players;
    }
}

public class Main {

    static List<Room> rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            int num = find(level, m);

            if (num == -1) {
                int low = level < 10 ? 0 : level - 10;
                int high = level + 10;
                List<Player> players = new ArrayList<>();
                players.add(new Player(name, level));
                rooms.add(new Room(low, high, players));
            } else {
                Room room = rooms.get(num);
                room.players.add(new Player(name, level));
            }
        }

        StringBuilder answer = new StringBuilder();

        for (Room room : rooms) {
            List<Player> players = room.players;
            players.sort(Comparator.comparing(player -> player.name));

            if (room.isLower(m)) {
                answer.append("Waiting!").append("\n");
                for (Player player : players) {
                    answer.append(player.level).append(" ").append(player.name).append("\n");
                }
            } else {
                answer.append("Started!").append("\n");
                for (Player player : players) {
                    answer.append(player.level).append(" ").append(player.name).append("\n");
                }
            }
        }

        System.out.println(answer);
    }

    static int find(int level, int m) {
        if (rooms.isEmpty()) return -1;

        for (int j = 0; j < rooms.size(); j++) {
            Room room = rooms.get(j);
            int low = room.low;
            int high = room.high;

            if (low <= level && level <= high && rooms.get(j).isLower(m)) {
                return j;
            }
        }

        return -1;
    }
}

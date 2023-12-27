import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st1.nextToken());
        int minute = Integer.parseInt(st1.nextToken());
        int cookingTime = Integer.parseInt(st2.nextToken());

        System.out.println(calculateHour(hour, minute, cookingTime) + " " + calculateMinute(minute, cookingTime));
    }

    private static int calculateHour(int hour, int minute, int cookingTime) {
        int plusHour = cookingTime / 60;
        int resultHour = hour + plusHour;
        if (((cookingTime % 60) + minute) > 59) {
            resultHour += 1;
        }
        if (resultHour > 23) {
            return resultHour % 24;
        }
        return resultHour;
    }


    private static int calculateMinute(int minute, int cookingTime) {
        int plusMinute = cookingTime % 60;
        int resultMinute = minute + plusMinute;
        if (resultMinute > 59) {
            return resultMinute % 60;
        }
        return resultMinute;
    }
}
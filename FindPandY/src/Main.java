import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
    }
    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            s = s.toLowerCase();

            long yCount = s.chars().filter(c -> c == 'y').count();
            long pCount = s.chars().filter(c -> c == 'p').count();

            if(yCount == pCount)
                answer = true;
            else
                answer = false;

            return answer;
        }
    }
}
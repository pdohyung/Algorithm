import java.util.Locale;

public class Main {
    public static void main(String[] args) {

    }

    class Solution {
        public String solution(String s) {

            char[] result = s.toCharArray();
            int cnt = 0;

            for (int i = 0; i < result.length; i++)
                if (result[i] == ' ') {
                    cnt = 0;
                    continue;
                } else {
                    if (cnt % 2 == 0)
                        result[i] = Character.toUpperCase(result[i]);
                    else
                        result[i] = Character.toLowerCase(result[i]);
                    cnt++;
                }
            s = new String(result);
            return s;
        }

    }

}

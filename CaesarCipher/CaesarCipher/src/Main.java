public class Main {
    public class Solution{
        private char push(char c, int n){
            if(!Character.isAlphabetic(c)) return c;

            int offset = Character.isUpperCase(c) ? 'A' : 'a';
            int pos = c - offset;
            pos = (pos + n) % ('Z' - 'A' + 1);
            return (char) (offset + pos);
        }

        public String solution(String s, int n){
            StringBuilder builder = new StringBuilder();
            for(char c : s.toCharArray()){
                builder.append(push(c, n));
            }
            return builder.toString();
        }
    }
    public static void main(String[] args) {

    }
}
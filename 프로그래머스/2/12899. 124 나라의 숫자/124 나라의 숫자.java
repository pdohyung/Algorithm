class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        return convert(n, sb).reverse().toString();
    }

    public StringBuilder convert(int num, StringBuilder sb) {
        if (num == 0) {
            return sb;
        }
        if (num % 3 == 0) {
            sb.append("4");
        }
        if (num % 3 == 1) {
            sb.append("1");
        }
        if (num % 3 == 2) {
            sb.append("2");
        }

        return convert((num - 1) / 3, sb);
    }
}
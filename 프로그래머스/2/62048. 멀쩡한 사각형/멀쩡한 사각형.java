class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h;

        long gcd = gcd(w, h);

        long widthSize = (long)w / gcd;
        long heightSize = (long)h / gcd;

        long blankBlock = widthSize + heightSize - 1;

        return answer - blankBlock * gcd;
    }

    private int gcd(int a, int b) {
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
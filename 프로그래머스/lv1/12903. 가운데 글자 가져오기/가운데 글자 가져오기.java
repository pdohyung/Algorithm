class Solution {
    public String solution(String s) {
        int length = s.length();
        int middleIndex = length / 2;

        if (length % 2 == 0) {
            return s.substring(middleIndex - 1, middleIndex + 1);
        } else {
            return s.charAt(middleIndex) + "";
        }
    }
}
class Solution {
    public int solution(String s) {

        char firstChar = s.charAt(0);

        if(firstChar == '-'){
            String numStr = s.substring(1);
            int num = Integer.parseInt(numStr);
            return -num;
        }
        else{
            int num = Integer.parseInt(s);
            return num;
        }
    }
}
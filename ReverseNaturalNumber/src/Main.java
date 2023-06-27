public class Main {
    class Solution{
        public int[] solution(long n){
           String toStr = Long.toString(n);
           String reverse = new StringBuilder(toStr).reverse().toString();
           char[] arr = reverse.toCharArray();

           int[] answer = new int[arr.length];
           for(int i = 0; i < arr.length; i++){
               answer[i] = arr[i] - '0';
            }
           return answer;
        }
    }

    public static void main(String[] args) {
    }
}
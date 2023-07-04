import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }
    class Solution{
        public boolean solution(String s){
            return (s.length() == 4 || s.length() == 6) && s.chars().allMatch(Character::isDigit);
        }

        /*
        public boolean solution(String s){
         if(s.length() != 4 && s.length() != 6) return false;
         for(char c : s.toCharArray()){
             if(!Character.isDigit(c)) return false;
         }
         return true;
        }*/
    }
}
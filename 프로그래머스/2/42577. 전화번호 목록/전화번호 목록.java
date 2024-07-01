import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        //System.out.println(Arrays.toString(phone_book));
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            String pre = phone_book[i];
            String next = phone_book[i + 1];
            
            if(next.startsWith(pre)) {
                return false;
            }
        }
        
        return true;
    }
}
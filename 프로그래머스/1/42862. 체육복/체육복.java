import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {    
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int l : lost) {
            boolean found = false;
            for (int r : reserve) {
                if (l == r) {
                    found = true;
                    break;
                }
            }
            if (!found) lostList.add(l);
        }
        
        for (int r : reserve) {
            boolean found = false;
            for (int l : lost) {
                if (r == l) {
                    found = true;
                    break;
                }
            }
            if (!found) reserveList.add(r);
        }
        
        Collections.sort(lostList);
        Collections.sort(reserveList);
        int answer = n - lostList.size();
        
        for (int r : reserveList) {
            for (int i = 0; i < lostList.size(); i++) {
                int l = lostList.get(i);
                if (Math.abs(r - l) == 1) {
                    answer++;
                    lostList.remove(i);
                    break;
                }
            }
        }
    
        return answer;
    }
}

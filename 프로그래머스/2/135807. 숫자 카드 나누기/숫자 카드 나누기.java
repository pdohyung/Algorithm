import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 철수가 가진 모든 숫자를 나누고, 영희가 가진 숫자를 나눌 수 없는 양의 정수 a
        // 영의가 가진 숫자를 모두 나누고, 철수가 가진 숫자를 나눌수 없는 양의 정수 a
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        for (int i = 1; i <= arrayA[0]; i++)
            if(arrayA[0] % i == 0) listA.add(i);
        
        for (int i = 1; i <= arrayB[0]; i++)
            if(arrayB[0] % i == 0) listB.add(i);
        
        int answer = Math.max(check(listA, arrayA, arrayB), check(listB, arrayB, arrayA));
        
        return answer;
    }
    
    int check(List<Integer> list, int[] arrayA, int[] arrayB) {
        List<Integer> now = new ArrayList<>();
        
        for (int a : list) {
            boolean flag = false;
            
            for (int t : arrayA) {
                if (t % a != 0) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) now.add(a);
        }
        
        List<Integer> next = new ArrayList<>();
        
        for (int a : now) {
            boolean flag = false;
            
            for (int t : arrayB) {
                if (t % a == 0) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) next.add(a);
        }
        
        int answer = 0; 
        if (!next.isEmpty()) answer = next.get(next.size() - 1);
        
        return answer;
    }
}

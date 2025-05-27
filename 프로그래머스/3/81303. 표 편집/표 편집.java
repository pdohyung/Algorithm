import java.util.*;

class Remove {
    int i, v;
    
    Remove(int i, int v) {
        this.i = i;
        this.v = v;
    }
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 한 명령어에 한 행만 선택 가능함
        // U는 윗행, D는 아래행
        // C는 현재 행 삭제 후 바로 아래 행 선택 마지막 행이면, 바로 윗행
        // Z는 가장 최근에 삭제한 행을 복구, 선택된 행(now)은 바뀌지 않음, Z를 여러번 실행할 수도 있으므로 전체 기록 필요
        int now = k;
        Stack<Remove> R = new Stack<>();
        LinkedList<Integer> table = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            table.add(i);
        }
        
        // table.remove(0);
        // table.add(n, 100);
        // table.add(n + 1, 100);
        // table.add(n + 2, 100);
        // table.add(n + 3, 100);
        
        for (String c : cmd) {
            String[] line = c.split(" ");
            char oper = line[0].charAt(0);
            
            if (oper == 'U') {
                now -= Integer.parseInt(line[1]);
            } else if (oper == 'D') {
                now += Integer.parseInt(line[1]);
            } else if (oper == 'C') {
                R.push(new Remove(now, table.remove(now)));
                
                if (table.size() == now) now--;
            } else {
                Remove p = R.pop();
                table.add(p.i, p.v);
                
                if (p.i <= now) now++;
            }
            // System.out.println(now + " size = " + table.size());
            // System.out.println(table);
            // System.out.println(R);
            // System.out.println();
        }
        
        boolean[] result = new boolean[n];
        Arrays.fill(result, true);
        
        while (!R.isEmpty()) {
            result[R.pop().i] = false;
        }
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (result[i]) answer.append("O");
            else answer.append("X");
        }
        
        return answer.toString();
    }
}

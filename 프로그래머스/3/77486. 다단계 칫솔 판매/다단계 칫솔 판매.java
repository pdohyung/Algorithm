import java.util.*;

class Solution {
    
    int[] result, parent;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 판매자 본인은 90%만 가지고 부모에게 10%를 보냄
        // center까지 분배되거나 10%를 계산한 금액이 1원 미만이면 자신이 가짐
        int eLen = enroll.length;
        int sLen = seller.length;
        
        // 이름들을 인덱스화
        Map<String, Integer> E = new HashMap<>();
        
        E.put("center", 0);
        
        for (int i = 1; i <= eLen; i++) {
            E.put(enroll[i - 1], i);
        }
        
        // 부모 설정
        parent = new int[eLen + 1];
        
        for (int i = 1; i <= eLen; i++) {
            String r = referral[i - 1];
            if (r.equals("-")) continue;
            parent[i] = E.get(r);
        }
        
        // DFS로 결과 저장
        result = new int[eLen];
        for (int i = 0; i < sLen; i++) {
            int now = E.get(seller[i]);
            int v = amount[i] * 100;
            dfs(now, v);
        }
    
        // 디버깅용 출력
        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(result));
        
        return result;
    }
    
    void dfs(int now, int v) {
        if (now == 0 || v == 0) {
            return;
        }

        int next = parent[now];
        int other = (v * 10) / 100;
        int me = v - other;

        result[now - 1] += me;
        dfs(next, other);
    }
}

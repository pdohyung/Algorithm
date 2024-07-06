import java.util.*;
import java.io.*;

class Solution {
    
    static HashMap<String, Integer> menus;
    static String sortedOrder;
    static int[] max;
    static int N;
    static int courseIdx;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        menus = new HashMap<>();
        max = new int[course.length]; // 각 코스별 최대 주문 횟수
        
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            sortedOrder = String.copyValueOf(order); // 다른 메뉴 로직에 영향이 없도록 copy
            
            for(int j = 0; j < course.length; j++) {
                courseIdx = j;
                N = course[j];
                dfs(0, 0, "");
            }
        }
        
        for (int i = 0; i < course.length; i++) {
            for (String menu : menus.keySet()) {
                if (max[i] != 1 && menus.get(menu) == max[i] && menu.length() == course[i]) {
                    answer.add(menu);
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.stream().map(String::toString).toArray(String[]::new);
    }
    
    private static void dfs(int cnt, int idx, String course) {
        if (cnt == N) {
            //System.out.println(course);
            menus.put(course, menus.getOrDefault(course, 0) + 1);
            int cur = menus.get(course);
            max[courseIdx] = Math.max(max[courseIdx], cur);
            return;
        }
        
        for (int i = idx; i < sortedOrder.length(); i++) {
            dfs(cnt + 1, i + 1, course + sortedOrder.charAt(i));
        }
    }
                         
}
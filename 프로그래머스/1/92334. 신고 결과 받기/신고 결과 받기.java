import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCount = new LinkedHashMap<>();
        Map<String, Integer> mailCount = new LinkedHashMap<>();
        Map<String, ArrayList<String>> reportMap = new LinkedHashMap<>();
        List<String> restrictedUsers = new ArrayList<>();

        for (String s : id_list) {
            reportCount.put(s, 0);
            mailCount.put(s, 0);
        }

        // 각 사용자가 신고한 유저 리스트를 저장
        for (String s : report) {
            String[] split = s.split(" ");

            if (!reportMap.containsKey(split[0])) {
                reportMap.put(split[0], new ArrayList<>());
            }

            if (!reportMap.get(split[0]).contains(split[1])) {
                reportCount.put(split[1], reportCount.get(split[1]) + 1);
                reportMap.get(split[0]).add(split[1]);
            }
        }

//        for (String key : reportCount.keySet()) {
//            System.out.println(key + " " + reportCount.get(key).toString());
//        }
//
//        System.out.println();

        for (String key : reportCount.keySet()) {
            if (reportCount.get(key) >= k) {
                restrictedUsers.add(key);
            }
        }

        for (String key : reportMap.keySet()) {
            for (String s : restrictedUsers) {
                if (reportMap.get(key).contains(s)) {
                    mailCount.put(key, mailCount.get(key) + 1);
                }
            }
        }

        return mailCount.values().stream().mapToInt(Integer::intValue).toArray();

//        for (int a : array) {
//            System.out.println(a);
//        }
    }
}
import java.util.*;
import java.io.*;

class Solution {
    
    static int[] nfees;
    
    public int[] solution(int[] fees, String[] records) {
        
        nfees = fees;
        
        HashMap<String, Integer> table = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        List<String> keys = new ArrayList<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            int time = calculateTime(record[0]);
            String carNum = record[1];
            String type = record[2];
            
            // System.out.println(Arrays.toString(record));
            
            // 입차 처리
            if(type.equals("IN")) {
                table.put(carNum, time);
            } else { // 출차 처리
                int inTime = table.get(carNum);
                //int price = calculatePrice(time - inTime);
                result.put(carNum, result.getOrDefault(carNum, 0) + time - table.get(carNum));
                table.put(carNum, -1);
            }
        }
        
        // 23:59까지 출차하지 않은 차량들 처리
        for(String key : table.keySet()) {
            if(table.get(key) != -1) {
                int inTime = table.get(key);
                int outTime = calculateTime("23:59");
                result.put(key, result.getOrDefault(key, 0) + outTime - inTime);
            }
        }
                
        for(String key : result.keySet()) {
            keys.add(key);
        }
        
        Collections.sort(keys);
        
        int[] answer = new int[keys.size()];
        
        for(int i = 0; i < answer.length; i++) {
            String key = keys.get(i);
            answer[i] = calculatePrice(result.get(key));
        }
    
        return answer;
    }
    
    static int calculateTime(String input) {
        String[] hAndMin = input.split(":");
        int time = 0;
        time += 60 * Integer.parseInt(hAndMin[0]) + Integer.parseInt(hAndMin[1]);
        // System.out.println(time);
        return time;
    }
    
    static int calculatePrice(int time) {
        
        int extraTime = time - nfees[0];
        int cnt = extraTime / nfees[2];
        
        if(time <= nfees[0]) {
            return nfees[1];
        } else {
            
            if(extraTime % nfees[2] != 0) {
                cnt++;
            }
             
            return nfees[1] + cnt * nfees[3];
        }
    }
}
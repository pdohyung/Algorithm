import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int len = 0;
        m = convert(m);
        System.out.println(m);
        
        for (String infos : musicinfos) {
            String[] info = infos.split(",");
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");
            String name = info[2];
            String ms = convert(info[3]);
            
            int sH = Integer.parseInt(startTime[0]);
            int sM = Integer.parseInt(startTime[1]);
            
            int eH = Integer.parseInt(endTime[0]);
            int eM = Integer.parseInt(endTime[1]);
            
            int totalTime = (eH - sH) * 60 + (eM - sM);
            StringBuilder totalM = new StringBuilder();
            int now = 0;
            
            for (int i = 0; i < totalTime; i++) {
                totalM.append(ms.charAt(now));
                now = (now + 1) % ms.length();
            }
            
            if (totalM.toString().contains(m) && len < totalTime) {
                len = totalTime;
                answer = name;
            }
            
            System.out.println(totalM);
        }
        
        return answer;
    }
    
    public String convert(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#", "d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        s = s.replaceAll("A#", "a");
        s = s.replaceAll("B#", "b");
        return s;
    }
}

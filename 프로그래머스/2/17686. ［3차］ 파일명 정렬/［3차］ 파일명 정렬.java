import java.util.*;

class Info {
    String head;
    int number, pos;

    Info(String head, int number, int pos) {
        this.head = head;
        this.number = number;
        this.pos = pos;
    }
}

class Solution {
    public String[] solution(String[] files) {
        List<Info> list = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            String f = files[i];
            String head = "";
            String number = "";
            boolean flag = false;
            
            for (char c : f.toCharArray()) {
                if (Character.isDigit(c)) {
                    flag = true;
                    number += c;
                } else if (!Character.isDigit(c) && flag) {
                    break;
                } else {
                    head += c;
                }
            }
            
            list.add(new Info(head.toUpperCase(), Integer.parseInt(number), i));
        }
        
        list.sort((a, b) -> {
            if (!a.head.equals(b.head)) return a.head.compareTo(b.head);
            else if (a.number != b.number) return Integer.compare(a.number, b.number); 
            else return Integer.compare(a.pos, b.pos);
        });
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = files[list.get(i).pos];
        }
        
        return answer;
    }
}

import java.io.*;
import java.util.*;

class MessageState {
    String type;
    String id;

    public MessageState(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> usernameMap = new LinkedHashMap<>();
        List<MessageState> messageTypeList = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            String userId = split[1];

            switch (split[0]) {
                case "Enter":
                    usernameMap.put(userId, split[2]);
                    messageTypeList.add(new MessageState("Enter", userId));
                    //messageTypeMap.put(userId, "Enter");
                    break;
                case "Leave":
                    messageTypeList.add(new MessageState("Leave", userId));
                    //messageTypeMap.put(userId, "Leave");
                    break;
                case "Change":
                    usernameMap.put(userId, split[2]);
                    break;
            }
        }
        
        String[] res = new String[messageTypeList.size()];

//        for (String s : usernameMap.values()) {
//            System.out.println(s);
//        }

        for (int i = 0; i < messageTypeList.size(); i++) {
            MessageState messageState = messageTypeList.get(i);
            switch (messageState.getType()) {
                case "Enter":
                    res[i] = usernameMap.get(messageState.getId()) + "님이 들어왔습니다.";
                    break;
                case "Leave":
                    res[i] = usernameMap.get(messageState.getId()) + "님이 나갔습니다.";
            }
        }
        
        return res;
    }
}
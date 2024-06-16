class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
         String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String binary1 = toBinary(arr1[i], n);
            String binary2 = toBinary(arr2[i], n);
            //System.out.println(binary1 + " " + binary2);
            for (int j = 0; j < n; j++) {
                //System.out.println(binary1.charAt(j) + " " + binary2.charAt(j));
                if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
                    sb.append("#");
                    continue;
                }
                sb.append(" ");
            }
            answer[i] = sb.toString();
            //System.out.println(answer[i]);
        }
        
        return answer;
    }
    
     String toBinary(int num, int len) {
        String binary = Integer.toBinaryString(num);
        int paddingLen = len - binary.length();

        if (paddingLen > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paddingLen; i++) {
                sb.append(0);
            }
            sb.append(binary);
            return sb.toString();
        }

        return binary;
    }
}
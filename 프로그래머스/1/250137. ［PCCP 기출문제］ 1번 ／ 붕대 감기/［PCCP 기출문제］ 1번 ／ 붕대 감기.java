class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 붕대 감기는 t초 동안 붕대를 감고, 1초마다 x만큼 회복, t초 연속 성공하면 y만큼 체력을 회복
        // 캐릭터는 최대 체력이 존재, 기술을 쓰는 도중에 공격을 당하면 취소, 즉시 다시 시작, 0초로 초기화
        // 공격을 받으면 피해량만큼 감소, 0 이하가 되면 체력 회복 불가
        // 캐릭터가 끝까지 생존할 수 있는지 리턴, 0 이하가 되어 죽는다면 -1 리턴
        int len = attacks.length;
        int last = attacks[len - 1][0];
        int answer = 0;
        int s = 0;
        int i = 0;
        int cnt = 0;
        int h = health;
        
        while (s < last) {
            s++;
            // System.out.println("s = " +  s + " h = " + h);
            if (i < len && attacks[i][0] == s) {
                cnt = 0;
                h -= attacks[i++][1];
                
                if (h <= 0) {
                    // System.out.println(h);
                    answer = -1;
                    break;
                }
            } else {
                cnt++;
                h = h + bandage[1] > health ? health : h + bandage[1];
                
                if (cnt == bandage[0]) {
                    cnt = 0;
                    h = h + bandage[2] > health ? health : h + bandage[2];
                }
            }
            
            answer = h;
        }
        
        return answer;
    }
}

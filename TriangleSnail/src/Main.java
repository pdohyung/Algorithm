public class Main {
    public static void main(String[] args) {
        int n = 4;
       int[][] triangle = new int[n][n];
       int v = 1;
       int x = 0, y = 0;

       while(true){

           while(true) {
               triangle[y][x] = v++;
               if (y == n - 1 || triangle[y + 1][x] != 0) break;
               ++y;
           }
           if(x == n - 1 || triangle[y][x + 1] != 0) break;
           ++x;

           while(true){
               triangle[y][x] = v++;
               if(x == n - 1 || triangle[y][x+1] != 0) break;
               ++x;
           }
           if(triangle[y-1][x-1] != 0) break;
           --x;
           --y;

           while(true){
               triangle[y][x] = v++;
               if(triangle[y-1][x-1] != 0) break;
               --y;
               --x;
           }
           if(y == n - 1 || triangle[y+1][x] != 0) break;
           ++y;

       }

       int[] result = new int[v - 1];

       int index = 0;
       for(int i = 0; i < n; i++){
           for(int j = 0; j <= i; j++){
               if(triangle[i][j] != 0)
                   result[index++] = triangle[i][j];
           }
       }


    }
}
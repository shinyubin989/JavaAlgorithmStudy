class Solution {
    public int solution(int[][] triangle) {
        
        int[][] arr = new int[triangle.length][triangle.length];
        
        arr[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j == 0) arr[i][j] = triangle[i][j] + arr[i-1][j];
                else if(j == i) arr[i][j] = triangle[i][j] + arr[i-1][j-1];
                else arr[i][j] = Math.max(triangle[i][j]+arr[i-1][j-1], triangle[i][j]+arr[i-1][j]);
            }
        }
        
        int max = 0;
        int row = triangle.length - 1;
        for(int i=0; i<triangle.length; i++){
            if(max < arr[row][i]) max = arr[row][i];
            
        }
        
        return max;
    }
}

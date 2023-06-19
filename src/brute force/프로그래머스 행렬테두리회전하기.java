class Solution{
public int[] solution(int rows, int columns, int[][] queries) {

    int[][] arr = new int[rows][columns];
    int count = 1;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = count;
        count++;
      }
    }

    int[] answer = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int x1 = queries[i][0] - 1;
      int x2 = queries[i][2] - 1;
      int y1 = queries[i][1] - 1;
      int y2 = queries[i][3] - 1;

      int temp1 = arr[x1][y1];
      int temp4 = arr[x2][y1];
      int temp3 = arr[x2][y2];
      int temp2 = arr[x1][y2];

      int min = temp1;

      for (int j = y1 + 1; j <= y2; j++) {
        int after = arr[x1][j];
        arr[x1][j] = temp1;
        temp1 = after;
        min = Math.min(min, temp1);
      }

      for (int j = x1 + 1; j <= x2; j++) {
        int after = arr[j][y2];
        arr[j][y2] = temp2;
        temp2 = after;
        min = Math.min(min, temp2);
      }

      for (int j = y2 - 1; j >= y1; j--) {
        int after = arr[x2][j];
        arr[x2][j] = temp3;
        temp3 = after;
        min = Math.min(min, temp3);
      }

      for (int j = x2 - 1; j >= x1; j--) {
        int after = arr[j][y1];
        arr[j][y1] = temp4;
        temp4 = after;
        min = Math.min(min, temp4);
      }

      answer[i] = min;
    }

    return answer;
  }
}

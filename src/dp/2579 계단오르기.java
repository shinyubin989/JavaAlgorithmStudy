import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] input = new int[n+1];
    for (int i = 1; i <= n; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }
    if (n < 3) {
      if (n == 1) {
        System.out.println(input[1]);
      } else {
        System.out.println(Math.max(input[2], input[1]+input[2]));
      }
    } else {
      int[][] arr = new int[n+1][3];
      arr[1][1] = input[1];
      arr[2][1] = input[2];
      arr[2][2] = input[1] + input[2];
      for (int i = 3; arr[n][1] == 0 || arr[n][2] == 0; i++) {
        arr[i][1] = Math.max(arr[i - 2][1], arr[i - 2][2]) + input[i];
        arr[i][2] = arr[i - 1][1] + input[i];
      }
      System.out.println(Math.max(arr[n][1], arr[n][2]));
    }
  }
}

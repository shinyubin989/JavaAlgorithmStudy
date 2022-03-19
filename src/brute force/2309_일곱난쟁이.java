import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
  
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    int input;

    int[] arr = new int[9];
    int[] output = new int[9];
    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      input = Integer.parseInt(st.nextToken());
      arr[i] = input;
    }
    Arrays.sort(arr);

    int sum = 0;
    for (int i = 0; i < 9; i++) {
      sum += arr[i];
    }

    int x, y, a = 10, b = 10;
    for (int i = 0; i < 9; i++) {
      int xPlusY = 0;
      for (int j = i + 1; j < 9; j++) {
        x = arr[i];
        y = arr[j];

        xPlusY = x + y;
        a = i;
        b = j;

        if(sum-xPlusY == 100) break;
      }
      if(sum-xPlusY == 100) break;
    }

    for (int i = 0; i < 9; i++) {
      if(i == a || i == b) continue;
      System.out.println(arr[i]);
    }
  }
}

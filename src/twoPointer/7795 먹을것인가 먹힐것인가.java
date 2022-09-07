
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int numOfTestCase = Integer.parseInt(st.nextToken());
    for (int i = 0; i < numOfTestCase; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      int[] arrA = new int[A];
      int[] arrB = new int[B];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < A; j++) {
        arrA[j] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < B; j++) {
        arrB[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arrB);

      int count = 0;
      for (int j = 0; j < A; j++) {
        for (int k = B - 1; k >= 0; k--) {
          if (arrA[j] > arrB[k]) {
            count += k + 1;
            break;
          }

        }
      }

      System.out.println(count);

    }
  }
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[] arr;
  public static int n, m;
  public static boolean[] isUsed;
  public static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[10];
    isUsed = new boolean[10];
    solution(0);
    System.out.println(sb);
  }

  public static void solution(int k) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        sb.append(arr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 1; i <= n ; i++) {
      if (!isUsed[i]) {
        arr[k] = i;
        isUsed[i] = true;
        solution(k+1);
        isUsed[i] = false;
      }
    }
  }
}

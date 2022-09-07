
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.max;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[1010];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[1010];
    int count = 0;
    for (int i = 1; i <= N; i++) {
      dp[i] = 1;
      for (int j = i - 1; j >= 1; j--) {
        if (arr[i] > arr[j]) {
          dp[i] = max(dp[i], dp[j] + 1);
        }
      }
      count = max(dp[i], count);
    }
    
    System.out.println(count);
  }
}

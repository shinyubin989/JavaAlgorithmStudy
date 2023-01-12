import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int k = Integer.parseInt(br.readLine());

    sb.append((1<<k) - 1).append("\n");
    solution(1, 3, k, sb);
    System.out.println(sb);
  }

  public static void solution(int a, int b, int n, StringBuilder sb) {
    if (n == 1) {
      sb.append(a).append(" ").append(b).append("\n");
      return;
    }
    solution(a, 6 - a - b, n - 1, sb); // n-1개의 원판을 기둥 a에서 기둥 6-a-b로 옮긴다
    sb.append(a).append(" ").append(b).append("\n"); // n번 원판을 기둥 a에서 기둥 b로 옮긴다
    solution(6 - a - b, b, n - 1, sb); // n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다
  }
}

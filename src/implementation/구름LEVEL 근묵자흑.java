import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if(N<=K) System.out.println(1);
    else if ((N - K) % (K - 1) == 0) {
      System.out.println((N - K) / (K - 1) + 1);
    } else {
      System.out.println((N-K)/(K-1) + 2);
    }

  }
}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int n = Integer.parseInt(st.nextToken());
    int[] arrY = new int[500000];
    int count = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arrY[i] = y;
    }
    for (int i = 0; i <= n; i++) {
      while (!stack.isEmpty() && (stack.peek() > arrY[i])) {
        count++;
        stack.pop();
      }
      if (!stack.isEmpty() && (stack.peek() == arrY[i])) {
        continue;
      }

      stack.push(arrY[i]);
    }



    System.out.println(count);
  }
}

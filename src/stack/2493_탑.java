import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = Integer.parseInt(br.readLine());

    int[] arr = new int[num + 1];
    int[] output = new int[num + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < num; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    StringBuilder stringBuilder = new StringBuilder();

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < num; i++) {
      while (stack.size() > 0) {
        if (arr[stack.peek()] >= arr[i]) {
          output[i] = stack.peek() + 1;
          break;
        }
        else{
          stack.pop();
        }
      }
      stack.push(i);
    }

    for (int i = 0; i < num; i++) {
      stringBuilder.append(output[i]).append(" ");
    }
    System.out.println(stringBuilder);
    br.close();
    bw.close();
  }
}

 /*
6 9 5 7 4
6
-> 0
9 (6 pop)
-> 0
9 5
-> 2
9 7 (5 pop)
-> 2
9 7 4
-> 4
  */

import java.io.*;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/Stack/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = Integer.parseInt(br.readLine());
    String[] input = new String[num];
    Stack<String> stack = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < num; i++) {
      input[i] = br.readLine();
    }
    for (int i = 0; i < num; i++) {
      if (input[i].contains(" ")) {
        String[] newStr = input[i].split(" ");
        stack.push(newStr[1]);
      } else if (input[i].equals("pop")) {
        if (stack.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(stack.peek()).append("\n");
          stack.pop();
        }
      } else if (input[i].equals("size")) {
        stringBuilder.append(stack.size()).append("\n");
      } else if (input[i].equals("top")) {
        if (stack.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(stack.peek()).append("\n");
        }
      } else {
        //empty
        if (stack.isEmpty()) {
          stringBuilder.append("1").append("\n");
        } else {
          stringBuilder.append("0").append("\n");
        }
      }
    }

    System.out.println(stringBuilder);
  }
}

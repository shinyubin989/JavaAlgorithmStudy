package LooftopGarden;

import java.io.*;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/LooftopGarden/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    long[] input = new long[num];
    Stack<Long> stack = new Stack<>();
    long sum = 0L;

    for (int i = 0; i < num; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < num; i++) {
      while (!stack.isEmpty()) {
        if (stack.peek() <= input[i]) {
          stack.pop();
        } else {
          break;
        }
      }
      sum += stack.size();
      stack.push(input[i]);
    }

    System.out.println(sum);
  }
}

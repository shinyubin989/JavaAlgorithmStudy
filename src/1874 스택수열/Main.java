package StackSequence;

import java.io.*;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/StackSequence/input.txt"));

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = Integer.parseInt(br.readLine());
    int[] input = new int[num];
    StringBuilder stringBuilder = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < num; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }

    int index = 0;
    for (int i=1; i<=num; i++) {
      stack.push(i);
      stringBuilder.append("+").append("\n");
      while (!stack.isEmpty()) {
        if (stack.peek() == input[index]) {
          stack.pop();
          stringBuilder.append("-").append("\n");
          index++;
        } else {
          break;
        }
      }
    }

    if (!stack.isEmpty()) {
      System.out.println("NO");
    } else {
      System.out.println(stringBuilder);
    }

    br.close();
    bw.close();
  }
}

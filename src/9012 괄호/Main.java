package Parenthesis;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int num = Integer.parseInt(br.readLine());
    int count = 0;

    // (()())((()))

    for (int i = 0; i < num; i++) {
      char[] arr = br.readLine().toCharArray();
      for (int j = 0; j < arr.length; j++) {
        if (count >= 0) {
          if (arr[j] == '(') {
            count++;
          } else {
            count--;
          }
        }
        else {
          break;
        }
      }
      if (count == 0) {
        sb.append("YES").append("\n");

      } else {
        sb.append("NO").append("\n");
      }
      count = 0;

    }
    System.out.println(sb);

  }
}

/**
 * 6
 * (())())
 * (((()())()
 * (()())((()))
 * ((()()(()))(((())))()
 * ()()()()(()()())()
 * (()((())()(
 */

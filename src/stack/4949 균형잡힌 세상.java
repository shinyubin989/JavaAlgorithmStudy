import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String sentence = br.readLine();
      if (Objects.equals(sentence, ".")) {
        break;
      }

      String[] character = sentence.split("");

      System.out.println(mainLogic(character));

    }
  }

  public static String mainLogic(String[] character) {

    Stack<String> stack = new Stack<>();
    for (int i = 0; !character[i].equals("."); i++) {
      if (character[i].equals("(") || character[i].equals("[") ) {
        stack.push(character[i]);
      }

      if (character[i].equals(")")) {
        if (stack.isEmpty()) {
          return "no";
        }
        if (stack.peek().equals("(")) {
          stack.pop();
        } else {
          return "no";
        }
      }
      if (character[i].equals("]")) {
        if (stack.isEmpty()) {
          return "no";
        }
        if (stack.peek().equals("[")) {
          stack.pop();
        } else {
          return "no";
        }
      }
    }

    if (stack.isEmpty()) {
      return "yes";
    } else {
      return "no";
    }
  }
}

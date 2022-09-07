import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    //System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    StringTokenizer stringTokenizer;
    Deque<String> deque = new ArrayDeque<>();
    int num = Integer.parseInt(br.readLine());

    for (int i = 0; i < num; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      String st = stringTokenizer.nextToken();
      if (Objects.equals(st, "push_front")) {
        deque.addFirst(stringTokenizer.nextToken());
      } else if (Objects.equals(st, "push_back")) {
        deque.addLast(stringTokenizer.nextToken());
      } else if (Objects.equals(st, "pop_front")) {
        if (deque.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(deque.getFirst()).append("\n");
          deque.pollFirst();
        }
      } else if (Objects.equals(st, "pop_back")) {
        if (deque.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(deque.getLast()).append("\n");
          deque.pollLast();
        }
      } else if (Objects.equals(st, "size")) {
        stringBuilder.append(deque.size()).append("\n");
      } else if (Objects.equals(st, "empty")) {
        if (deque.isEmpty()) {
          stringBuilder.append("1").append("\n");
        } else {
          stringBuilder.append("0").append("\n");
        }
      } else if (Objects.equals(st, "front")) {
        if (deque.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(deque.getFirst()).append("\n");
        }
      } else {
        //back
        if (deque.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(deque.getLast()).append("\n");
        }
      }

    }

    System.out.println(stringBuilder);

  }
}

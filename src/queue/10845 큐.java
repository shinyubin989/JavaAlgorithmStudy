import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    StringTokenizer stringTokenizer;
    Queue<String> queue = new LinkedList<>();
    int num = Integer.parseInt(br.readLine());

    String back = "";
    for (int i = 0; i < num; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      String st = stringTokenizer.nextToken();
      if (Objects.equals(st, "push")) {
        back = stringTokenizer.nextToken();
        queue.add(back);
      } else if (Objects.equals(st, "front")) {
        if (queue.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(queue.peek()).append("\n");
        }
      } else if (Objects.equals(st, "back")) {
        if (queue.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(back).append("\n");
        }
      } else if (Objects.equals(st, "size")) {
        stringBuilder.append(queue.size()).append("\n");
      } else if (Objects.equals(st, "empty")) {
        if (queue.isEmpty()) {
          stringBuilder.append("1").append("\n");
        } else {
          stringBuilder.append("0").append("\n");
        }
      } else {
        //pop
        if (queue.isEmpty()) {
          stringBuilder.append("-1").append("\n");
        } else {
          stringBuilder.append(queue.peek()).append("\n");
          queue.poll();
        }
      }

    }

    System.out.println(stringBuilder);

  }
}

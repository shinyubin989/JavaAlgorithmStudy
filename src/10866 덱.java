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
    System.setIn(new FileInputStream("src/input.txt"));
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























//import java.io.*;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//class Pair implements Comparable<Pair>{
//  int docNum;
//  int priority;
//
//  public Pair(int docNum, int priority) {
//    this.docNum = docNum;
//    this.priority = priority;
//  }
//
//  @Override
//  public int compareTo(Pair o) {
//    return o.priority - priority;
//  }
//}
//
//public class Main {
//  public static void main(String[] args) throws IOException {
//    System.setIn(new FileInputStream("src/input.txt"));
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder stringBuilder = new StringBuilder();
//    StringTokenizer stringTokenizer;
//    Queue<Pair> queue = new LinkedList<>();
//
//    int num = Integer.parseInt(br.readLine());
//
//    for (int i = 0; i < num; i++) {
//      stringTokenizer = new StringTokenizer(br.readLine());
//      int documentNumber = Integer.parseInt(stringTokenizer.nextToken());
//      int documentPriority = Integer.parseInt(stringTokenizer.nextToken());
//
//      stringTokenizer = new StringTokenizer(br.readLine());
//
//      stringBuilder.append(count).append("\n");
//
//    }
//    System.out.println(stringBuilder);
//
//
//
//    //queue.add(1);     // queue에 값 1 추가
////    queue.poll();       // queue에 첫번째 값을 반환하고 제거 비어있다면 null
////    queue.remove();     // queue에 첫번째 값 제거
////    queue.clear();      // queue 초기화
////    queue.peek();       // queue의 첫번째 값 참조
//
//
//    /**
//     * 3
//     *
//     * 1 0
//     * 5
//     * 4 2
//     * 1 2 3 4
//     * 6 0
//     * 1 1 9 1 1 1
//     */
//    // 문서의 개수 N(1 ≤ N ≤ 100), 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)
//    // N개 문서의 중요도가 차례대로 주어진다
//  }
//}

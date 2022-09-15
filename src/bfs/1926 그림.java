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
    int width = Integer.parseInt(st.nextToken());
    int height = Integer.parseInt(st.nextToken());
    int[][] arr = new int[width][height];

    for (int i = 0; i < width; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < height; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }


    Queue<Pair> queue = new LinkedList<>();
    boolean[][] visited = new boolean[width][height];
//    visited[0][0] = true;
//    queue.add(new Pair(0, 0));

    int[] temp1 = {1, 0, -1, 0};
    int[] temp2 = {0, 1, 0, -1};

    int count = 0;
    int maxSize = 0;

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        if (visited[i][j] || arr[i][j] == 0) continue;
        visited[i][j] = true;
        queue.add(new Pair(i, j));
        count++;
        int tempSize = 0;

        while (!queue.isEmpty()) {
          tempSize++;
          Pair cur = queue.remove();
          for (int k = 0; k < 4; k++) {
            int x = cur.x + temp1[k];
            int y = cur.y + temp2[k];

            if (x < 0 || y < 0 || x > width - 1 || y > height - 1) continue;
            if (visited[x][y] || arr[x][y] == 0) continue;

            queue.add(new Pair(x, y));
            visited[x][y] = true;
          }
        }
        maxSize = Math.max(maxSize, tempSize);
      }
    }

      System.out.println(count);
      System.out.println(maxSize);
  }
}

class Pair {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

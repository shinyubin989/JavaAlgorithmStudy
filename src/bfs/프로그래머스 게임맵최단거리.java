import java.awt.*;
import java.util.*;

class Solution {
  int n,m;
  int[][] maps;
  int[][] visited;
  int[] dx = {1, -1, 0, 0};
  int[] dy = {0, 0, 1, -1};
  Queue<Point> queue = new LinkedList<>();
  public int solution(int[][] maps) {
    this.maps = maps;
    n = maps.length;
    m = maps[0].length;
    visited = new int[n][m];
    visited[0][0] = 1;
    queue.add(new Point(0, 0));
    while (!queue.isEmpty()) {
      for (int j = 0; j < queue.size(); j++) {
        Point cur = queue.poll();
        for (int i = 0; i < 4; i++) {
          int nx = cur.x + dx[i];
          int ny = cur.y + dy[i];
          if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
          if(visited[nx][ny]!=0 || maps[nx][ny] != 1) continue;
          visited[nx][ny] = visited[cur.x][cur.y] + 1;
          queue.add(new Point(nx, ny));
        }
      }
    }
    return visited[n-1][m-1] == 0 ? -1 : visited[n-1][m-1];
  }
}

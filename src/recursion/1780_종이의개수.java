import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int[][] arr;
  public static int minusOne = 0;
  public static int zero = 0;
  public static int one = 0;

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int k = Integer.parseInt(br.readLine());
    arr = new int[k][k];
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < k; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    solution(0, 0, arr.length);
    System.out.println(minusOne);
    System.out.println(zero);
    System.out.println(one);
  }

  public static void solution(int row, int col, int size) {
    if (isAllSameNumber(row, col, size)) {
      if(arr[row][col] == -1) minusOne++;
      else if(arr[row][col] == 0) zero++;
      else one++;
      return;
    } else {
      int temp = size / 3;
      solution(row, col, temp);
      solution(row, col + temp, temp);
      solution(row, col + 2 * temp, temp);
      solution(row + temp, col, temp);
      solution(row + temp, col + temp, temp);
      solution(row + temp, col + 2 * temp, temp);
      solution(row + 2 * temp, col, temp);
      solution(row + 2 * temp, col + temp, temp);
      solution(row + 2 * temp, col + 2 * temp, temp);
    }
  }

  public static boolean isAllSameNumber(int row, int col, int size) {
    int num = arr[row][col];
    for (int i = row; i < row+size; i++) {
      for (int j = col; j < col+size; j++) {
        if (num != arr[i][j]) return false;
      }
    }
    return true;
  }
}

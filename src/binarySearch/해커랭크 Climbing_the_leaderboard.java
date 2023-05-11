import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY ranked
   *  2. INTEGER_ARRAY player
   */

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    List<Integer> rank = ranked.stream().distinct().collect(toList());
    List<Integer> answer = new ArrayList<>();
    for (int element : player) {
      // element가 가작 작은 경우
      if (element < rank.get(rank.size() - 1)) {
        answer.add(rank.size() + 1);
        continue;
      }
      // element가 가장 큰 경우
      if(element > rank.get(0)) {
        answer.add(1);
        continue;
      }
      answer.add(binarySearch(rank, 0, rank.size() - 1, element) + 1);
    }
    return answer;
  }

  public static int binarySearch(List<Integer> rank, int low, int high, int element) {
    // 이진탐색 high와 low가 역전되지 않을때까지 반복
    while (high >= low) {
      int mid = (low + high) / 2;

      // mid번째에 찾는값이 딱 있는 경우
      if (rank.get(mid) == element) return mid;
      // mid보단 작지만 mid+1보단 큰 경우 -> mid + 1
      if (rank.get(mid) > element && rank.get(mid + 1) < element) return mid + 1;
      // mid-1보단 작지만 mid보단 큰 경우 -> mid
      if (rank.get(mid) < element && rank.get(mid - 1) > element) return mid;

      // mid보다 큰 경우 -> 이분할 중 앞부분을 다시 탐색하도록 high=mid-1로 넘겨줌
      else if (rank.get(mid) < element) return binarySearch(rank, low, mid - 1, element);
      // mid보다 작은 경우 -> 이분할 중 뒷부분을 다시 탐색하도록 low=mid+1로 넘겨줌
      return binarySearch(rank, mid + 1, high, element);
    }
    return -1;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
      .map(Integer::parseInt)
      .collect(toList());

    List<Integer> result = Result.climbingLeaderboard(ranked, player);

    bufferedWriter.write(
      result.stream()
        .map(Object::toString)
        .collect(joining("\n"))
        + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}

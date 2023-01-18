import java.util.*;

class Solution {
  public int solution(int[] numbers, int target) {
    return dfs(numbers, 0, 0, target);
  }

  int dfs(int[] numbers, int n, int sum, int target) {
    if (n == numbers.length) {
      if(sum == target) return 1; else return 0;
    }
    return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
  }
}

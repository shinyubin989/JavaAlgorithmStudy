import java.util.*;
class Solution {
  public int solution(int N, int number) {
    List<Set<Integer>> list = new LinkedList<>();
    for (int i = 0; i < 9; i++) {
      list.add(new HashSet<>());
    }
    list.get(1).add(N);
    if(N == number) return 1;

    for (int i = 2; i < 9; i++) {
      Set<Integer> set = list.get(i);
      for (int j = 1; j < i; j++) {
        Set<Integer> preSet = list.get(j);
        Set<Integer> postSet = list.get(i - j);

        for (int a : preSet) {
          for (int b : postSet) {
            set.add(a + b);
            set.add(a - b);
            set.add(a * b);
            if (a != 0 && b != 0) {
              set.add(a / b);
            }
          }
        }
        set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
      }

      for (int temp : set) {
        if(temp == number) return i;
      }
    }
    return -1;
  }
}

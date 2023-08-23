import java.util.*;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        List<String> list = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for (int i = 0; i < course.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int combinationSize = course[i];
            for (int j = 0; j < orders.length; j++) {
                int n = orders[j].length();
                if(combinationSize > n) continue;
                combination(map, combinationSize, n, 0, new boolean[n], orders[j]);
            }

            List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));

            if(entryList.isEmpty()) continue;
            int max = entryList.get(0).getValue();
            for (int j = 0; j < entryList.size(); j++) {
                if(entryList.get(j).getValue() == max && entryList.get(j).getValue() != 1) list.add(entryList.get(j).getKey());
                else break;
            }
        }
        Collections.sort(list);

        return list.toArray(new String[0]);
    }

    public void combination(Map<String, Integer> map, int r, int n, int start, boolean[] visited, String string) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) sb.append(string.charAt(i));
            }
            String result = sb.toString();
            int count = map.getOrDefault(result, 0);
            map.put(result, count + 1);
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(map, r - 1, n, i + 1, visited, string);
                visited[i] = false;
            }
        }
    }
}

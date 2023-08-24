import java.util.*;

class Solution {

    public int[] solution(int[] fees, String[] records) {

        int defaultMinute = fees[0];
        int defaultFee = fees[1];
        int unitMinute = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> answer = new TreeMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            int minute = calculateMinute(arr[0]);
            String car = arr[1];
            String inout = arr[2];

            if (inout.equals("IN")) {
                map.put(car, minute);
                continue;
            }

            Integer min = answer.getOrDefault(car, 0) + (minute - map.get(car));
            answer.put(car, min);
            map.remove(car);
        }
        if (!map.isEmpty()) {
            for (String key : map.keySet()) {
                int lastTime = calculateMinute("23:59");
                Integer minute = answer.getOrDefault(key, 0) + (lastTime - map.get(key));
                answer.put(key, minute);
            }
        }


        List<Integer> list = new ArrayList<>();
        for (String key : answer.keySet()) {
            int minute = answer.get(key);
            if (minute <= defaultMinute) list.add(defaultFee);
            else {
                list.add(defaultFee + ((int) Math.ceil((double) (minute-defaultMinute) / unitMinute)) * unitFee);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();

    }

    public int calculateMinute(String string) {
        String[] befores = string.split(":");
        int hour = Integer.parseInt(befores[0]);
        int minute = Integer.parseInt(befores[1]);

        return (hour * 60 + minute);
    }
}

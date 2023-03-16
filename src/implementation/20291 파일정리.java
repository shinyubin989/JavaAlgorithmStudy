
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st = new StringTokenizer(br.readLine());
    int size = Integer.parseInt(st.nextToken());
    String[] files = new String[size];
    for (int i = 0; i < size; i++) {
      files[i] = br.readLine();
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < files.length; i++) {
      String[] file = files[i].split("\\.");
      map.put(file[1], map.getOrDefault(file[1], 0) + 1);
    }
    Map<String, Integer> treemap = new TreeMap<>(map);
    for (String key : treemap.keySet()) { //저장된 key값 확인
      System.out.println(key + " " + map.get(key));
    }
  }
}

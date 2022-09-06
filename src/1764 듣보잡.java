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

    int notListened = Integer.parseInt(st.nextToken());
    int notSeen = Integer.parseInt(st.nextToken());

    HashSet<String> hashSet = new HashSet();

    for (int i = 0; i < notListened; i++) {
      st = new StringTokenizer(br.readLine());
      hashSet.add(st.nextToken());
    }

    ArrayList<String> arrayList = new ArrayList<>();

    for (int i = 0; i < notSeen; i++) {
      st = new StringTokenizer(br.readLine());
      String string = st.nextToken();
      if (hashSet.contains(string)) {
        arrayList.add(string);
      }
    }

    Collections.sort(arrayList);

    System.out.println(arrayList.size());
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.println(arrayList.get(i));
    }
  }
}

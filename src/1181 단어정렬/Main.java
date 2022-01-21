package WordSort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/WordSort/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = Integer.parseInt(br.readLine());
    String[] input = new String[num];
    for (int i = 0; i < num; i++) {
      input[i] = br.readLine();
    }
    Arrays.sort(input, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
          return o1.compareTo(o2);
        } else {
          return o1.length() - o2.length();
        }
      }
    });

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(input[0]).append("\n");
    for (int i = 1; i < num; i++) {
      if (!input[i].equals(input[i - 1])) {
        stringBuilder.append(input[i]).append("\n");
      }
    }
    System.out.println(stringBuilder);


  }
}

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String input = st.nextToken();
    char[] arr = input.toCharArray();
    int[] output = new int[26];

    for (int i = 0; i < arr.length; i++) {
      int temp = arr[i] - 'a';
      output[temp]++;
    }

    for (int i = 0; i < output.length; i++) {
      System.out.print(output[i] + " ");
    }
  }
}

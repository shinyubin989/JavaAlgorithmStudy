import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("src/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = Integer.parseInt(br.readLine());
    boolean isPrime = true;
    int count = 0;

    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

    for (int i = 0; i < num; i++) {
      isPrime = true;
       int temp = Integer.parseInt(stringTokenizer.nextToken());
       if(temp == 1) continue;
      for (int j = 2; j <= Math.sqrt(temp); j++) {
        if (temp % j == 0) {
          isPrime = false;
        }
      }
      if(isPrime) count++;
    }
    System.out.println(count);


  }
}

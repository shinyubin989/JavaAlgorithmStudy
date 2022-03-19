import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start = input.nextInt();
        int end = input.nextInt();
        boolean isPrime = true;
        if (start == 1) {
            start++;
        }
        for (int i = start; i <= end; i++) {
            for (int j = 2; j*j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(i);
            }
            isPrime = true;
        }
    }
}

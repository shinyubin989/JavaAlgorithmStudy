package AgeSort;

import java.util.*;

class Pair{
    int age;
    String name;
    public Pair(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public int first() {
        return age;
    }
    public String second() {
        return name;
    }

    public String toResult() {
        return age + " " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int first = input.nextInt();
            String second = input.nextLine();
            Pair pair = new Pair(first, second);
            list.add(pair);
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.age - o2.age;
            }
        });
        for (Pair i : list) {
            System.out.println(i.toResult());
        }
    }
}


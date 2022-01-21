package Coordinate2Sort;

import java.util.*;


class Pair{
    int y;
    int x;
    public Pair(int x, int y) {
        this.y = y;
        this.x = x;
    }
    public int first() {
        return x;
    }
    public int second() {
        return y;
    }
    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Pair> list = new ArrayList<>();
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            int first = input.nextInt();
            int second = input.nextInt();
            Pair pair = new Pair(first, second);
            list.add(pair);
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.second() == o2.second()) {
                    return o1.x - o2.x;
                } else {
                    return o1.y - o2.y;
                }
            }
        });

        for (Pair i : list) {
            System.out.println(i);
        }

    }
}

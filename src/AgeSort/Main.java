package AgeSort;

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
    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class Main {
    public static void main(String[] args) {}
}


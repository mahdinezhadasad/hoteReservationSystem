package service;

public class Singleton {

    private static Singleton single_instance = null;

    private String s;

    private Singleton() {

        s = "Hello I am  String part of Singelton class";

    }

    public static Singleton getInstance() {

        if (single_instance == null) {   single_instance = new Singleton();
        }
        return single_instance;
    }

    static class Main {

        public static void main(String[] args) {
            Singleton x = Singleton.getInstance();
            Singleton y = Singleton.getInstance();
            Singleton z = Singleton.getInstance();

            x.s = (x.s).toUpperCase();
            System.out.println("String from x is " + x.s);
            System.out.println("String from yis " + y.s);
            System.out.println("String from z is" + z.s);
        }
    }

}




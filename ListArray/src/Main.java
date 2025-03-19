import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ListArray<Integer> lista = new ListArray<>();

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.put(12);
        System.out.println(lista.len() + " -> " + lista.size());

        lista.popAt(10);
        System.out.println(lista.len() + " -> " + lista.size());


        lista.putAt(7, 3);
        System.out.println(lista.len() + " -> " + lista.size());
        System.out.println(lista.getAt(7));
        lista.printArray();
        lista.popAt(7);
        System.out.println(lista.len() + " -> " + lista.size());
        System.out.println(lista.getAt(7));
        lista.printArray();


    }
}


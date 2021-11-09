package dio.everis;

public class Main {

    public static void main(String[] args) {

        ListaDuplamenteEncadeada<String> minhaListaEncadeada = new ListaDuplamenteEncadeada<>();

        minhaListaEncadeada.add("m1");
        minhaListaEncadeada.add("m2");
        minhaListaEncadeada.add("m3");
        minhaListaEncadeada.add("m4");
        minhaListaEncadeada.add("m5");
        minhaListaEncadeada.add("m6");
        minhaListaEncadeada.add("m7");

        System.out.println(minhaListaEncadeada);

        minhaListaEncadeada.remove(3);
        minhaListaEncadeada.add(3, "99");

        System.out.println(minhaListaEncadeada);
        System.out.println(minhaListaEncadeada.get(3));
    }
}
import java.util.ArrayList;

public class Reinas {
    public static void main(String[] args) {
        Buscador b = new Buscador(8);
        ArrayList<Tablero> tableros = b.resolver();

        tableros.forEach(System.out::println);
        System.out.println("SOLUCIONES: " + tableros.size());
    }
}

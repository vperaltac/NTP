public class Reinas {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(3);
        tablero.ponerReina(0,1);
        tablero.ponerReina(0,0);
        tablero.ponerReina(2,2);

        System.out.println(tablero);
    }
}

import java.util.ArrayList;

public class Buscador {
    private final int dimension;

    Buscador(int dimension){
        this.dimension = dimension;
    }

    public ArrayList<Tablero> resolver(){
        return ubicarReina(dimension-1);
    }

    public ArrayList<Tablero> ubicarReina(int fila){
        ArrayList<Tablero> tableros = new ArrayList<>();

        if(fila == -1){
            Tablero tablero = new Tablero(dimension);
            tableros.add(tablero);
        }
        else{
            ArrayList<Tablero> soluciones = new ArrayList<>();
            tableros = ubicarReina(fila-1);

            for (Tablero tablero : tableros) {
                for (int j = 0; j < dimension; j++){
                    Celda c1 = new Celda(fila, j);
                    if (tablero.posicionSegura(c1)) {
                        Tablero t = new Tablero(tablero);
                        t.ponerReina(fila, j);
                        soluciones.add(t);
                    }
                }
            }

            tableros = soluciones;
        }

        return tableros;
    }
}

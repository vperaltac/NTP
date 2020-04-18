import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            ArrayList<Tablero> soluciones = ubicarReina(fila-1);

            List<Tablero> sols = soluciones.stream()
                    .flatMap(tablero -> IntStream.range(0,dimension)
                    .boxed()
                    .map(col -> {
                            Celda c1 = new Celda(fila, col);

                            Tablero t = null;
                            if(tablero.posicionSegura(c1)){
                                t = new Tablero(tablero);
                                t.ponerReina(fila,col);
                            }

                            return t;
                        })
                    .filter(Objects::nonNull))
                    .collect(Collectors.toList());

            tableros.addAll(sols);
        }

        return tableros;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tablero {
    private final int dimension;
    private final ArrayList<Celda> contenido;

    public Tablero(int dimension){
        this.dimension = dimension;
        contenido = new ArrayList<>();
    }

    public Tablero(Tablero otro){
        this.dimension = otro.dimension;
        this.contenido = new ArrayList<>(otro.contenido);
    }

    public void ponerReina(int fila, int columna){
        Celda celda = new Celda(fila,columna);
        contenido.add(celda);
    }

    public boolean posicionSegura(Celda celda){
        List<Celda> conflictos = contenido.stream()
                .filter(c -> Celda.conflicto(celda,c))
                .collect(Collectors.toList());

        return conflictos.size() <= 0;
    }

    public boolean celdaOcupada(int fila, int columna){
        List<Celda> ocupadas = contenido.stream()
                .filter(celda -> celda.getFila() == fila && celda.getColumna() == columna)
                .collect(Collectors.toList());

        return ocupadas.size() > 0;
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                if(celdaOcupada(i,j))
                    salida.append("R ");
                else
                    salida.append("X ");
            }
            salida.append("\n");
        }

        return salida.toString();
    }
}

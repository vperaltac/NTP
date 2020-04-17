import java.util.ArrayList;

public class Tablero {
    private int dimension;
    private ArrayList<Celda> contenido;

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
        boolean segura = true;

        for(int i=0;i<contenido.size();i++){
            if(Celda.conflicto(celda,contenido.get(i)))
                segura = false;
        }

        return segura;
    }

    public boolean celdaOcupada(int fila, int columna){
        boolean ocupada = false;

        for(int i=0;i<contenido.size();i++){
            if(contenido.get(i).getFila() == fila && contenido.get(i).getColumna() == columna)
                ocupada = true;
        }

        return ocupada;
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

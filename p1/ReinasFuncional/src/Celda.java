import static java.lang.Math.abs;

public class Celda {
    private final int fila;
    private final int columna;

    Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public static boolean conflicto(Celda c1, Celda c2){
        if(c1.getFila() == c2.getFila() || c1.getColumna() == c2.getColumna())
            return true;
        else return abs(c1.getFila() - c2.getFila()) == abs(c1.getColumna() - c2.getColumna());
    }
}
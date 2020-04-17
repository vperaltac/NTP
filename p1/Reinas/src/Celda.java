import static java.lang.Math.abs;

public class Celda {
    private int fila;
    private int columna;

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

    // TODO: comprobar que funciona correctamente para diagonales izq-dcha
    public static boolean conflicto(Celda c1, Celda c2){
        if(c1.getFila() == c2.getFila() && c1.getColumna() == c2.getColumna())
            return true;
        else return abs(c1.getFila() - c1.getColumna()) != abs(c2.getFila() - c2.getColumna());
    }
}

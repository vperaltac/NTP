import java.io.File;

public class ViajanteComercio {
    public static void main (String [] args){
        Problema problema = new Problema("small4.tsp");

        VecinoMasCercano vmc = new VecinoMasCercano();
        vmc.calcularRutaOptima(problema);
    }
}

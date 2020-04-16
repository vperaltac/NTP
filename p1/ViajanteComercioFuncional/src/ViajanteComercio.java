import java.io.File;

public class ViajanteComercio {
    public static void main (String [] args){
        Problema problema = new Problema("data/test6.tsp");

        VecinoMasCercano vmc = new VecinoMasCercano();
        Ruta ruta = vmc.calcularRutaOptima(problema);
        System.out.println("Ruta VecinoMasCercano: " + ruta);
    }
}
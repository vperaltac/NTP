import java.io.File;

public class ViajanteComercio {
    public static void main (String [] args){
        Problema problema = new Problema("berlin52.tsp");

        VecinoMasCercano vmc = new VecinoMasCercano();
        Ruta ruta = vmc.calcularRutaOptima(problema);
        System.out.println("Ruta VecinoMasCercano: " + ruta);

        MonteCarlo mc = new MonteCarlo();
        Ruta ruta_mc = mc.calcularRutaOptima(problema);
        System.out.println("Ruta MonteCarlo: " + ruta_mc);
    }
}
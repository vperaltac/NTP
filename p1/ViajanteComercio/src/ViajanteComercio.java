import java.io.File;

public class ViajanteComercio {
    public static void main (String [] args){
        Problema problema = new Problema("test6.tsp");

        VecinoMasCercano vmc = new VecinoMasCercano();
        Ruta ruta = vmc.calcularRutaOptima(problema);
        System.out.println(ruta);
        System.out.println("Distancia: " + ruta.getDistancia());
    }
}
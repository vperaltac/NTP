import java.util.*;
import java.util.stream.DoubleStream;

public class VecinoMasCercano implements HeuristicaTSP{
    @Override
    public Ruta calcularRutaOptima(Problema problema){
        Ruta ruta = new Ruta();
        List<Ciudad> ciudades = problema.getCiudades();
        Vector<Vector<Double>> distancias = problema.getDistancias();

        ruta.agregarCiudad(ciudades.get(0));

        ciudades.forEach(ciudad_actual -> {
            double min = distancias.get(0).stream()
                    .filter(dist -> dist > 0)
                    .mapToDouble(Double::doubleValue)
                    .min().getAsDouble();

            int index = distancias.get(0).indexOf(min);

            // añadir ciudad a ruta
            ruta.agregarCiudad(ciudades.get(distancias.get(0).indexOf(min)));
        });

        return ruta;
    }
}

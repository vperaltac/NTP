import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class VecinoMasCercano implements HeuristicaTSP{
    @Override
    public Ruta calcularRutaOptima(Problema problema){
        Ruta ruta = new Ruta();
        List<Ciudad> ciudades = problema.getCiudades();
        Vector<Vector<Double>> distancias = problema.getDistancias();

        ruta.agregarCiudad(ciudades.get(0));
        ciudades.forEach(ciudad_actual -> ruta.agregarCiudad(ciudades.get(siguienteCiudad(ruta,distancias))));

        return ruta;
    }

    private int siguienteCiudad(Ruta ruta, Vector<Vector<Double>> distancias){
        List<Ciudad> ciudades = ruta.getCiudades();
        Ciudad ultima_ciudad = ciudades.get(ciudades.size()-1);
        int index_ciudad = Integer.parseInt(ultima_ciudad.getLabel())-1;
        Vector<Double> distancias_filtradas = new Vector<>();

        ciudades.forEach(ciudad -> {
            if(ruta.ciudadEnRuta(ciudad))
                distancias_filtradas.add(distancias.get(index_ciudad).get(Integer.parseInt(ciudad.getLabel())-1));
        });

        Predicate<Double> condicion = dist -> (dist > 0 && !distancias_filtradas.contains(dist));

        if(distancias_filtradas.size() == distancias.size())
            return Integer.parseInt(ciudades.get(0).getLabel())-1;
        else{
            double min = distancias.get(index_ciudad).stream()
                    .filter(condicion)
                    .mapToDouble(Double::doubleValue)
                    .min().getAsDouble();

            return distancias.get(index_ciudad).indexOf(min);
        }
    }
}

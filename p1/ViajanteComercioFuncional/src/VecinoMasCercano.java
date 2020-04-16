import java.util.*;
import java.util.function.Predicate;

public class VecinoMasCercano implements HeuristicaTSP{
    @Override
    public Ruta calcularRutaOptima(Problema problema){
        Ruta ruta = new Ruta();
        List<Ciudad> ciudades = problema.getCiudades();
        Vector<Vector<Double>> distancias = problema.getDistancias();

        ruta.agregarCiudad(ciudades.get(0),0.0);
        ciudades.forEach(ciudad_actual -> {
            Subruta siguiente = siguienteCiudad(ciudades,ruta,distancias);
            ruta.agregarCiudad(siguiente.getCiudad(),siguiente.getDistancia());
        });

        return ruta;
    }

    private Subruta siguienteCiudad(List<Ciudad> ciudades_general, Ruta ruta, Vector<Vector<Double>> distancias){
        List<Ciudad> ciudades = ruta.getCiudades();
        Ciudad ultima_ciudad = ciudades.get(ciudades.size()-1);
        int index_ciudad = Integer.parseInt(ultima_ciudad.getLabel())-1;
        Vector<Double> distancias_filtradas = new Vector<>();

        // buscar ciudades en ruta
        ciudades.forEach(ciudad -> {
            if(ruta.ciudadEnRuta(ciudad))
                distancias_filtradas.add(distancias.get(index_ciudad).get(Integer.parseInt(ciudad.getLabel())-1));
        });

        // sólo añadir una ciudad que no sea la ciudad actual y que no esté en ruta
        Predicate<Double> condicion = dist -> (dist > 0 && !distancias_filtradas.contains(dist));

        Subruta siguiente;
        // la última ciudad se conecta con la primera
        if(distancias_filtradas.size() == distancias.size()){
            double distancia = distancias.get(index_ciudad).get(Integer.parseInt(ciudades.get(0).getLabel())-1);
            siguiente = new Subruta(ciudades.get(0),distancia);
        }
        else{ // buscar ciudad mas cercana
            double min = distancias.get(index_ciudad).stream()
                    .filter(condicion)
                    .mapToDouble(Double::doubleValue)
                    .min().getAsDouble();

            siguiente = new Subruta(ciudades_general.get(distancias.get(index_ciudad).indexOf(min)),min);
        }

        return siguiente;
    }
}

import java.util.*;

public class VecinoMasCercano implements HeuristicaTSP{
    @Override
    public Ruta calcularRutaOptima(Problema problema){
        Ruta ruta = new Ruta();
        ArrayList<Ciudad> ciudades = problema.getCiudades();
        Vector<Vector<Double>> distancias = problema.getDistancias();
        ArrayList<Boolean> ciudades_en_ruta = new ArrayList<>();

        for(int i=0;i<ciudades.size();i++){
            ciudades_en_ruta.add(false);
        }

        ruta.agregarCiudad(ciudades.get(0),0);
        ciudades_en_ruta.set(0,true);

        boolean encontrado = false;
        int i=0,num_it=0,min = Integer.MAX_VALUE;

        while(num_it < ciudades.size()-1){
            // Cálculo del minimo inicial
            for(int j=0;j<ciudades.size() && !encontrado; j++){
                if(i != j && !ciudades_en_ruta.get(j)){
                    min = j;
                    encontrado = true;
                }
            }

            // Búsqueda de ciudad mas cercana
            for(int j=0;j<ciudades.size();j++){
                if(i != j && distancias.get(i).get(j) < distancias.get(i).get(min) && !ciudades_en_ruta.get(j)){
                    min = j;
                }
            }

            ruta.agregarCiudad(ciudades.get(i),distancias.get(i).get(min));
            i = min;
            ciudades_en_ruta.set(min,true);
            encontrado = false;
            num_it++;
        }

        // añadir distancia entre la última y la primera ciudad
        ruta.agregarCiudad(ciudades.get(0),distancias.get(0).get(min));

        return ruta;
    }
}

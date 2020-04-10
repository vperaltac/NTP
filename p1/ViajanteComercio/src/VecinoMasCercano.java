import java.util.*;

public class VecinoMasCercano implements HeuristicaTSP{
    @Override
    public Ruta calcularRutaOptima(Problema problema){
        Ruta ruta = new Ruta();
        ArrayList<Ciudad> ciudades = problema.getCiudades();
        Vector<Vector<Double>> distancias = problema.getDistancias();
        ArrayList<Boolean> visitado = new ArrayList<>();

        for(int i=0;i<ciudades.size();i++){
            visitado.add(false);
        }

        ruta.agregarCiudad(ciudades.get(0),0);
        visitado.set(0,true);

        boolean encontrado = false;
        int i=0,num_it=0,min = Integer.MAX_VALUE;

        while(num_it < ciudades.size()-1){
            // Cálculo del minimo inicial
            for(int j=0;j<ciudades.size() && !encontrado; j++){
                if(i != j && !visitado.get(j)){
                    min = j;
                    encontrado = true;
                }
            }

            // Búsqueda de ciudad mas cercana
            for(int j=0;j<ciudades.size();j++){
                if(i != j && distancias.get(i).get(j) < distancias.get(i).get(min) && !visitado.get(j))
                    min = j;
            }

            double distancia = distancias.get(i).get(min);
            i = min;
            ruta.agregarCiudad(ciudades.get(i),distancia);
            visitado.set(min,true);
            encontrado = false;
            num_it++;
        }

        // añadir distancia entre la última y la primera ciudad
        ruta.agregarCiudad(ciudades.get(0),distancias.get(0).get(min));

        return ruta;
    }
}

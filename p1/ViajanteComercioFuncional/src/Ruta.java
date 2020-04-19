import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ruta {
    private List<Ciudad> ciudades;
    private double distancia;

    public Ruta(){
        ciudades = new ArrayList<>();
        distancia = 0;
    }

    public void agregarCiudad(Ciudad ciudad, double distancia){
        ciudades.add(ciudad);
        this.distancia += distancia;
    }

    public void agregarCiudad(Ciudad ciudad){
        ciudades.add(ciudad);
    }

    public static Ruta generarRuta(Problema problema){
        Ruta r = new Ruta();
        Vector<Vector<Double>> distancias = problema.getDistancias();

        // generar ruta aleatoria
        List<Ciudad> ciudades = problema.getCiudades();
        List<Integer> ciuds = ciudades.stream()
                .map(c -> Integer.parseInt(c.getLabel())-1)
                .collect(Collectors.toList());
        Collections.shuffle(ciuds);

        // cálculo de distancia
        double distancia = IntStream.range(0, ciuds.size())
                .boxed()
                .mapToDouble(indice -> distancias.get(ciuds.get(indice)).get(ciuds.get((indice+1)%ciuds.size())))
                .sum();

        // añadir ciudades y distancia final a ruta
        ciuds.forEach(c -> r.agregarCiudad(ciudades.get(c)));
        r.agregarCiudad(ciudades.get(ciuds.get(0)),0.0);
        r.setDistancia(distancia);

        return r;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    public double getDistancia(){
        return distancia;
    }

    public List<Ciudad> getCiudades(){
        return ciudades;
    }

    public boolean ciudadEnRuta(Ciudad c){
        List<Ciudad> cs = ciudades.stream()
                .filter(ciudad -> ciudad.getLabel().equals(c.getLabel()))
                .collect(Collectors.toList());

        return cs.size() > 0;
    }

    @Override
    public String toString() {
        String info = "Ruta: ";
        for(Ciudad c : ciudades){
            info += c.getLabel() + " ";
        }
        info += "\nDistancia: " + distancia;

        return info;
    }
}
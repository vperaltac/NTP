import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

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

    public static Ruta generarRuta(Problema problema){
        Ruta r = new Ruta();
        Vector<Vector<Double>> distancias = problema.getDistancias();


        // generar ruta aleatoria
        List<Ciudad> ciudades = problema.getCiudades();
        List<Integer> ciuds = ciudades.stream()
                .map(c -> Integer.parseInt(c.getLabel())-1)
                .collect(Collectors.toList());
        Collections.shuffle(ciuds);

        ciuds.forEach(c -> {
            r.agregarCiudad(ciudades.get(c),distancias.get(c).get((c+1)%ciuds.size()));
        });

        r.agregarCiudad(ciudades.get(ciuds.get(0)),0.0);
        return r;
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
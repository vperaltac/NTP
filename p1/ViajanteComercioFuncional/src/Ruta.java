import java.util.ArrayList;
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
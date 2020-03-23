import java.util.ArrayList;
import java.util.Vector;

public class Ruta {
    private ArrayList<Ciudad> ciudades;
    private double coste;

    public Ruta(){
        ciudades = new ArrayList<>();
        coste = 0;
    }

    public void agregarCiudad(Ciudad ciudad, double distancia){
        ciudades.add(ciudad);
        coste += distancia;
    }

    public double getCoste() {
        return coste;
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    @Override
    public String toString() {
        String info = "Ruta: ";
        for(Ciudad c : ciudades){
            info += c.getLabel() + " ";
        }
        return info;
    }
}

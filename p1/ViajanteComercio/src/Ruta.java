import java.util.ArrayList;

public class Ruta {
    private ArrayList<Ciudad> ciudades;
    private double distancia;

    public Ruta(){
        ciudades = new ArrayList<>();
        distancia = 0;
    }

    public void agregarCiudad(Ciudad ciudad, double dist){
        ciudades.add(ciudad);
        distancia += dist;
    }

    public double getDistancia() {
        return distancia;
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

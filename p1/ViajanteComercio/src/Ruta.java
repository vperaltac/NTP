import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

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

    public static Ruta generarRuta(Problema problema){
        Ruta r = new Ruta();
        Vector<Vector<Double>> distancias = problema.getDistancias();

        // generar ruta aleatoria
        ArrayList<Ciudad> ciudades = problema.getCiudades();
        Collections.shuffle(ciudades);

        r.agregarCiudad(ciudades.get(0),0);
        for(int i=1;i<ciudades.size();i++){
            int ciudad1 = Integer.parseInt(ciudades.get(i).getLabel())-1;
            int ciudad2 = Integer.parseInt(ciudades.get(i-1).getLabel())-1;
            r.agregarCiudad(ciudades.get(i),distancias.get(ciudad1).get(ciudad2));
            //System.out.println(r);
        }

        r.agregarCiudad(ciudades.get(0),distancias.get(0).get(ciudades.size()-1));
        return r;
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

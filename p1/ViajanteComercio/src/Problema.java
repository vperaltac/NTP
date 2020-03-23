import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.Vector;

public class Problema {
    private ArrayList<Ciudad> ciudades;
    private int dimension;
    private Vector<Vector<Double>> distancias;

    public Problema(String nombre){
        try {
            String path = "data/" + nombre;
            File archivo = new File(path);
            Scanner scanner = new Scanner(archivo);

            // leer dimension del problema
            String data = scanner.nextLine();
            dimension  = Integer.parseInt(data.substring(11));

            // leer cada ciudad: nombre y coordenadas x,y
            ciudades = new ArrayList<Ciudad>();
            while(scanner.hasNextInt()){
                String etiqueta = scanner.next();
                int x = Integer.parseInt(scanner.next());
                int y = Integer.parseInt(scanner.next());

                Ciudad ciudad = new Ciudad(etiqueta,x,y);
                ciudades.add(ciudad);
            }

            inicializarMatriz();

        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

    }

    private void inicializarMatriz(){
        // reserva de espacio para la matriz de distancias
        distancias = new Vector<Vector<Double>>();

        for(int i=0;i<dimension;i++){
            Vector<Double> dist = new Vector<>();

            for(int j=0;j<dimension;j++){
                if(j != i){
                    dist.add(Euclidea(ciudades.get(i).getX(),ciudades.get(i).getY(),
                                      ciudades.get(j).getX(),ciudades.get(j).getY()));
                }
                else
                    dist.add(0.0);
            }

            distancias.add(dist);
        }
    }

    private double Euclidea(double x1, double y1, double x2, double y2){
        double a = (x2-x1)*(x2-x1);
        double b = (y2-y1)*(y2-y1);

        return Math.sqrt(a+b);
    }

    public int getDimension() {
        return dimension;
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public Vector<Vector<Double>> getDistancias() {
        return distancias;
    }
}
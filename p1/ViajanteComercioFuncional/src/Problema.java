import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problema {
    private List<Ciudad> ciudades;
    private Vector<Vector<Double>> distancias;

    public Problema(String nombre){
        try {
            // Se leen las lineas del archivo
            Stream<String> lineas = Files.lines(Paths.get(nombre));

            // Generar ciudades por cada linea del fichero
            // Se seleccionan sólo las lineas que no contengan la palabra DIMENSION y que tengan algún dígito
            ciudades = lineas
                    .filter(s -> s.matches(".*[^(DIMENSION:)] \\d.*"))
                    .map(Ciudad::new).collect(Collectors.toList());

            inicializarMatriz();
        } catch(IOException e){
            System.out.println("Error reading file: " + nombre);
            System.exit(0);
        }
    }

    private void inicializarMatriz(){
        // reserva de espacio para la matriz de distancias
        distancias = new Vector<Vector<Double>>();
        ciudades.forEach(c1 -> {
            Vector<Double> dist = new Vector<Double>();
            ciudades.forEach(c2 -> dist.add(Euclidea(c1.getX(),c1.getY(),c2.getX(),c2.getY())));
            distancias.add(dist);
        });
    }

    private double Euclidea(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public Vector<Vector<Double>> getDistancias() {
        return distancias;
    }
}
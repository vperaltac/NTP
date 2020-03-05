import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Problema {
    private ArrayList<Ciudad> ciudades;
    private int dimension;

    public Problema(String nombre){
        try {
            ciudades = new ArrayList<Ciudad>();

            File archivo = new File("data/small4.tsp");
            Scanner scanner = new Scanner(archivo);

            // leer dimension del problema
            String data = scanner.nextLine();
            dimension  = Integer.parseInt(data.substring(11));

            // leer cada ciudad: nombre y coordenadas x,y
            while(scanner.hasNextInt()){
                String etiqueta = scanner.next();
                int x = Integer.parseInt(scanner.next());
                int y = Integer.parseInt(scanner.next());

                Ciudad ciudad = new Ciudad(etiqueta,x,y);
                ciudades.add(ciudad);
            }

        } catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }

    }
}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problema {
    private List<Ciudad> ciudades;
    private int dimension;

    public Problema(String nombre){
        try {
            // Se leen las lineas del archivo
            Stream<String> lineas = Files.lines(Paths.get(nombre));

            // Se procesan las lineas del archivo
            ciudades = lineas
                    .filter(s -> s.matches(".*[^(DIMENSION:)] \\d.*"))
                    .map(linea -> new Ciudad(linea)).collect(Collectors.toList());

            ciudades.forEach(System.out::println);
        }catch(IOException e){
            System.out.println("Error reading file: " + nombre);
            System.exit(0);
        }
    }
}
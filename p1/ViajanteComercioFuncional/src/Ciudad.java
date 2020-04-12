import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Clase basica para representar una ubicacion en el problema
 * del TSP
 */
public class Ciudad {
    /**
     * Etiqueta para identificar la ciudad
     */
    private String etiqueta;

    /**
     * Datos miembro para almacenar las coordenadas de la ciudad
     */
    private double x;
    private double y;

    /**
     * Constructor de la clase
     *
     * @param etiqueta
     * @param coorx
     * @param coory
     */
    public Ciudad(String etiqueta, double coorx, double coory) {
        this.etiqueta = etiqueta;
        x = coorx;
        y = coory;
    }

    public Ciudad(String linea){
        // Se define el patron para las comas que hacen de separadores
        Pattern pattern = Pattern.compile("\\s+");

        // Se procesa la linea
        List<String> infos = pattern.splitAsStream(linea)
                .collect(Collectors.toList());

        etiqueta = infos.get(0);
        x = Double.parseDouble(infos.get(1));
        y = Double.parseDouble(infos.get(2));
    }

    /**
     * Obtiene la coordenada X
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Obtiene la coordenada Y
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * Obtiene la etiqueta
     *
     * @return
     */
    public String getLabel() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "etiqueta='" + etiqueta + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

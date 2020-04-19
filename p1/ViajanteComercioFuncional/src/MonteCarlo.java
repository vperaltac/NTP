import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MonteCarlo  implements HeuristicaTSP{
    private static final int NUM_RUTAS = 100;

    @Override
    public Ruta calcularRutaOptima(Problema problema) {
        List<Ruta> rutas = IntStream.range(0, NUM_RUTAS)
                .mapToObj(n -> Ruta.generarRuta(problema))
                .collect(Collectors.toList());

        Comparator<Ruta> comparador = Comparator.comparing(Ruta::getDistancia);
        Optional<Ruta> mejor_ruta = rutas.stream().min(comparador);

        return mejor_ruta.orElse(new Ruta());
    }
}
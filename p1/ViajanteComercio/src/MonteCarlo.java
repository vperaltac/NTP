public class MonteCarlo  implements HeuristicaTSP{
    private static final int NUM_RUTAS = 100;

    @Override
    public Ruta calcularRutaOptima(Problema problema) {
        Ruta ruta_final = Ruta.generarRuta(problema);

        for(int i=0;i<NUM_RUTAS-1;i++){
            Ruta ruta = Ruta.generarRuta(problema);

            if(ruta.getDistancia() < ruta_final.getDistancia()){
                ruta_final = ruta;
            }
        }

        return ruta_final;
    }
}

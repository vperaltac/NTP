public class Subruta {
    private Ciudad ciudad;
    private double distancia;

    public Subruta(Ciudad ciudad, double distancia){
        this.ciudad = ciudad;
        this.distancia = distancia;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public double getDistancia() {
        return distancia;
    }
}

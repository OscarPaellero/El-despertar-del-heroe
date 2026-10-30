public class arma extends juego
{
    private String nombre;
    private String descripcion;
    private int daño;

    public arma(String nombre, String descripcion, int daño)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.daño = daño;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getDaño() {
        return this.daño;
    }
}
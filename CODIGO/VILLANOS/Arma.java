package VILLANOS;

public class Arma
{
    private String nombre;
    private String descripcion;
    private int daño;

    public Arma(String nombre, String descripcion, int daño)
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
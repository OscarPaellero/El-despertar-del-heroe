package CODIGO.personajes;

public class personaje
{
    private String nombre;

    public personaje(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void presentar()
    {
        System.out.println("\n Soy " + this.nombre + " y soy un personaje del Señor de los Anillos");
    }

}

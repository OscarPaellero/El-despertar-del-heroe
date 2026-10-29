public class personaje
{
    private String nombre;
    private int vida;
    private arma armaPersonaje;
    private poder poderPersonaje;

    public personaje(String nombre, int vida, arma armaPersonaje, poder poderPersonaje)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.armaPersonaje = armaPersonaje;
        this.poderPersonaje = poderPersonaje;
    }

    public personaje(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public arma getArma() {
        return this.armaPersonaje;
    }

    public arma getPoder() {
        return this.poderPersonaje;
    }

}




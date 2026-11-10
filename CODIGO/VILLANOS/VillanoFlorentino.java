package VILLANOS;

import INTERFACES.IntTirador;
import INTERFACES.IntHechicero;

public class VillanoFlorentino extends Personaje implements IntTirador, IntHechicero
{
    private int municion = 3;
    private int mana = 30;
    private String hechizo;

    public VillanoFlorentino()
    {
        super("Florentino Perez", 120,
        new Arma("Fachada del Bernabeu", "Te tira una fachada que te tapa la vision y el siguiente golpe que haces lo fallas.", 17),
        new Poder("Fichaje galo", "Si eres Galo te quita un 20% de vida de un solo golpe.", 17));
        setDanoAtaque(8, 26);
    }

    @Override
    public boolean apuntar(int jugadorTOP)
    {
        System.out.println("| " + getNombre() + " apunta al jugador");
        return jugadorTOP > 0;
    }

    @Override
    public int disparar(int jugadorTOP)
    {
        if (this.municion <= 0) {
            return 0;
        }
        this.municion--;
        System.out.println("| " + getNombre() + " dispara con " + getPoder().getNombre());
        return getDanoAtaque();
    }

    @Override
    public void recargar(int cantidad)
    {
        this.municion = this.municion + cantidad;
        System.out.println("| " + getNombre() + " se queda sin municion y recarga " + cantidad);
    }

    @Override
    public void prepararHechizo(String hechizo)
    {
        this.hechizo = hechizo;
        System.out.println("| " + getNombre() + " prepara el hechizo: " + hechizo);
    }

    @Override
    public int lanzarHechizo(int jugadorTOP)
    {
        if (this.hechizo == null || this.mana < 10) {
            return 0;
        }
        this.mana = this.mana - 10;
        System.out.println("| " + getNombre() + " lanza el hechizo: " + this.hechizo);
        this.hechizo = null;
        return getDanoAtaque();
    }

    @Override
    public void recuperarMana(int cantidad)
    {
        this.mana = this.mana + cantidad;
        System.out.println("| " + getNombre() + " recupera " + cantidad + " de mana");
    }

    @Override
    public int turnoTirador(int vidaJugador)
    {
        apuntar(vidaJugador);
        int dano = disparar(vidaJugador);
        if (dano == 0) {
            recargar(3);
        }
        return dano;
    }

    @Override
    public int turnoHechicero(int vidaJugador)
    {
        int dano = lanzarHechizo(vidaJugador);
        if (dano == 0) {
            prepararHechizo(getPoder().getNombre());
            recuperarMana(10);
        }
        return dano;
    }
}
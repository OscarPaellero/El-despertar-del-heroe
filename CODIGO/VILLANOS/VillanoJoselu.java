package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntHechicero;

public class VillanoJoselu extends Personaje implements IntCombatiente, IntHechicero
{
    private int mana = 20;
    private String hechizo;

    public VillanoJoselu()
    {
        super("Joselu Mato", 80,
        new Arma("Poste de porteria", "Hace un x2 en uno de sus ataques.", 10),
        new Poder("Descendimiento", "Te quita 5 de vida, de vez en cuando.", 10));
        setDanoAtaque(5, 15);
        setEscudo(new Escudo(20));
        setUmbralEscudo(20);
    }

    @Override
    public int atacarConArma(int jugadorTOP)
    {
        setDefendiendo(false);
        System.out.println("| " + getNombre() + " ataca con " + getArma().getNombre());
        return getDanoAtaque();
    }

    @Override
    public void levantarEscudo()
    {
        if (getEscudo().estaRoto()) {
            System.out.println("| El escudo de " + getNombre() + " esta roto y no puede defenderse");
            return;
        }
        setDefendiendo(true);
        System.out.println("| " + getNombre() + " levanta el escudo para defenderse");
    }

    @Override
    public boolean escudoLevantado()
    {
        return isDefendiendo();
    }

    @Override
    public int getDefensa()
    {
        return getEscudo().getVida();
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
    public int turnoCombatiente(int vidaJugador)
    {
        boolean pocaVida = getVidaPorcentaje() < getUmbralEscudo();
        boolean puedeDefender = !escudoLevantado() && !getEscudo().estaRoto();

        if (pocaVida && puedeDefender && azar(100) < 70) {
            levantarEscudo();
            return 0;
        }
        return atacarConArma(vidaJugador);
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
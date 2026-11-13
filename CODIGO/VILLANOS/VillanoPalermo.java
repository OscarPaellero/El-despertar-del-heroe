package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntHechicero;
import INTERFACES.IntTirador;

public class VillanoPalermo extends Personaje implements IntCombatiente, IntTirador, IntHechicero
{
    private int municion = 1;
    private int mana = 30;
    private String hechizo;

    public VillanoPalermo()
    {
        super("Martin Palermo", 130,
        new Arma("Penal fallado", "Usa un penalti que te quita un x3 de vida.", 20),
        new Poder("Mal milagro de la lluvia", "Te anula 1 de cada 3 ataques.", 20));
        setDanoAtaque(15, 25);
        setEscudo(new Escudo(20));
        setUmbralEscudo(35);
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

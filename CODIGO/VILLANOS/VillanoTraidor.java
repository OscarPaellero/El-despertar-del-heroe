package VILLANOS;

import INTERFACES.IntCombatiente;

public class VillanoTraidor extends Personaje implements IntCombatiente
{
    // Siempre es el mismo combate, solo cambian el nombre (el aliado que traiciona) y la vida (fase 1 o 2)
    public VillanoTraidor(String nombre, int vida)
    {
        super(nombre, vida,
        new Arma("Golpe traicionero", "Un golpe por la espalda de quien confiabas.", 50),
        new Poder("Traicion", "Te ataca cuando menos lo esperas.", 50));
        setDanoAtaque(10, 25);
        setEscudo(new Escudo(20));
        setUmbralEscudo(25);
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
}
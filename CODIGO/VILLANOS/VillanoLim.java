package VILLANOS;

import INTERFACES.IntCombatiente;

public class VillanoLim extends Personaje implements IntCombatiente
{
    public VillanoLim()
    {
        super("Peter Lim", 100,
        new Arma("Silencio", "Te bloquea un ataque.", 12),
        new Poder("Venta forzosa", "Te quita una pocion.", 10));
        setDanoAtaque(5, 15);
        setEscudo(new Escudo(20));
        setUmbralEscudo(25);
    }

    @Override
    public int atacarConArma(int jugadorTOP) {
        setDefendiendo(false);
        System.out.println("| " + getNombre() + " ataca con " + getArma().getNombre());
        return getDanoAtaque();
    }

    @Override
    public void levantarEscudo() {
        if (getEscudo().estaRoto()) {
            System.out.println("| El escudo de " + getNombre() + " esta roto y no puede defenderse");
            return;
        }
        setDefendiendo(true);
        System.out.println("| " + getNombre() + " levanta el escudo para defenderse");
    }

    @Override
    public boolean escudoLevantado() {
        return isDefendiendo();
    }

    @Override
    public int getDefensa() {
        return getEscudo().getVida();
    }

    @Override
    public int turnoCombatiente(int vidaJugador) {
        boolean pocaVida = getVidaPorcentaje() < getUmbralEscudo();
        boolean puedeDefender = !escudoLevantado() && !getEscudo().estaRoto();

        if (pocaVida && puedeDefender && azar(100) < 70) {
            levantarEscudo();
            return 0;
        }
        return atacarConArma(vidaJugador);
    }
}
package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntInvocador;

public class VillanoLlorente extends Personaje implements IntCombatiente, IntInvocador
{
    private int invocados;

    public VillanoLlorente()
    {
        super("Fernando Llorente", 90,
        new Arma("Diente de leon", "Te apuñala quitandote 10 de vida.", 12),
        new Poder("Maman", "Sale una araña gigante que te quita 20 de vida.", 12));
        setDanoAtaque(6, 18);
        setEscudo(new Escudo(20));
        setUmbralEscudo(35);
        setCriatura("araña gigante");
        setMaxInvocados(3);
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
    public void invocar(String criatura)
    {
        this.invocados++;
        System.out.println("| " + getNombre() + " invoca a: " + criatura);
    }

    @Override
    public int NumeroInvocados()
    {
        return this.invocados;
    }

    @Override
    public int atacarConInvocados(int jugadorTOP)
    {
        int dano = 0;
        for (int i = 0; i < this.invocados; i++) {
            dano = dano + getDanoAtaque() / 2;
        }
        System.out.println("| Los " + this.invocados + " invocados de " + getNombre() + " atacan");
        return dano;
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
    public int turnoInvocador(int vidaJugador)
    {
        int actuales = NumeroInvocados();

        if (actuales < getMaxInvocados() && (actuales == 0 || azar(100) < 50)) {
            invocar(getCriatura());
            return 0;
        }
        if (actuales > 0) {
            return atacarConInvocados(vidaJugador);
        }
        return -1;
    }
}
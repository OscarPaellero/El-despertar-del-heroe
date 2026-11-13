package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntInvocador;
import INTERFACES.IntTirador;

public class VillanoLewandowski extends Personaje implements IntCombatiente, IntTirador, IntInvocador
{
    private int municion = 5;
    private int invocados;

    public VillanoLewandowski()
    {
        super("Lewandowski", 130,
        new Arma("Asalto de traicion", "Hace que uno de tus aliados te ataque sin querer.", 20),
        new Poder("La ramatada polaca", "Te tira 5 balonazos de 5 de vida menos cada uno.", 20));
        setDanoAtaque(15, 25);
        setEscudo(new Escudo(20));
        setUmbralEscudo(25);
        setCriatura("Aliado de los 9 minutos");
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

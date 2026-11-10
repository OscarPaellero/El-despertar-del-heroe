package VILLANOS;

import INTERFACES.IntCombatiente;
import INTERFACES.IntTirador;
import INTERFACES.IntSanador;

public class VillanoDonnarumma extends Personaje implements IntCombatiente, IntTirador, IntSanador
{
    private int municion = 6;
    private int pociones = 2;

    public VillanoDonnarumma()
    {
        super("Donnarumma", 250,
        new Arma("Billetardos", "Te tira billetes -7 por cada uno entre 5 y 15.", 40),
        new Poder("Parada", "Te anula un bloqueo cada 3 ataques.", 40));
        setDanoAtaque(20, 60);
        setEscudo(new Escudo(20));
        setUmbralEscudo(40);
        setUmbralCuracion(25);
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
    public void curar(int cantidad)
    {
        int nueva = getVida() + cantidad;
        if (nueva > getVidaMax()) {
            nueva = getVidaMax();
        }
        setVida(nueva);
        System.out.println("| " + getNombre() + " se cura y le quedan " + nueva + " de vida");
    }

    @Override
    public boolean necesitaCuracion()
    {
        return getVida() < getVidaMax();
    }

    @Override
    public int usarPocion()
    {
        if (this.pociones <= 0) {
            return 0;
        }
        this.pociones--;
        System.out.println("| " + getNombre() + " se bebe una pocion");
        curar(10);
        return 10;
    }

    @Override
    public int getPociones()
    {
        return this.pociones;
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
    public int turnoSanador(int vidaJugador)
    {
        boolean pocaVida = getVidaPorcentaje() < getUmbralCuracion();

        if (pocaVida && necesitaCuracion() && getPociones() > 0 && azar(100) < 80) {
            usarPocion();
            return 0;
        }
        return -1;
    }
}
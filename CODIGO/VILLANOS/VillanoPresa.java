package VILLANOS;

import INTERFACES.IntInvocador;
import INTERFACES.IntTirador;

public class VillanoPresa extends Personaje implements IntTirador, IntInvocador
{
    private int municion = 4;
    private int invocados;

    public VillanoPresa()
    {
        super("Martin Presa", 80,
        new Arma("Pelotas de golf", "Sus esbirros tiran enormes cantidades de estas pelotas.", 10),
        new Poder("Pelazo de señor", "Te tapa la vision con su pelo y no atacas durante 1 turno.", 10));
        setDanoAtaque(5, 15);
        setCriatura("Esbirro con pelotas de golf");
        setMaxInvocados(3);
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
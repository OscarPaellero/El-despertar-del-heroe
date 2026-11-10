package VILLANOS;

import INTERFACES.IntSanador;
import INTERFACES.IntInvocador;

public class VillanoBoateng extends Personaje implements IntSanador, IntInvocador
{
    private int pociones = 2;
    private int invocados;

    public VillanoBoateng()
    {
        super("Boateng", 250,
        new Arma("Hermano gemelo", "Se duplica y te quita el doble.", 40),
        new Poder("Entrada de un astro", "Tiene un 25% de aturdirte.", 40));
        setDanoAtaque(20, 60);
        setUmbralCuracion(60);
        setCriatura("hermano gemelo");
        setMaxInvocados(1);
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
    public int turnoSanador(int vidaJugador)
    {
        boolean pocaVida = getVidaPorcentaje() < getUmbralCuracion();

        if (pocaVida && necesitaCuracion() && getPociones() > 0 && azar(100) < 80) {
            usarPocion();
            return 0;
        }
        return -1;
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
package VILLANOS;

import INTERFACES.IntJinete;
import INTERFACES.IntTirador;

public class VillanoTevez extends Personaje implements IntTirador, IntJinete
{
    private int municion = 2;
    private String montura;
    private boolean tirado;

    public VillanoTevez()
    {
        super("Carlos Tevez", 200,
        new Arma("Cola de apache", "Le arranca la cola a un apache y te la lanza -15.", 30),
        new Poder("Noche azul", "Cambia el cielo por una noche que te hace no ver nada, y te anula 2 ataques.", 30));
        setDanoAtaque(15, 45);
        setAnimal("caballo apache");
        setUmbralMontura(20);
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
    public boolean montar(String animal)
    {
        if (this.montura != null || this.tirado) {
            return false;
        }
        this.montura = animal;
        System.out.println("| " + getNombre() + " monta en " + animal);
        return true;
    }

    @Override
    public boolean desmontar()
    {
        if (this.montura == null) {
            return false;
        }
        System.out.println("| " + getNombre() + " se baja de " + this.montura);
        this.montura = null;
        this.tirado = true;
        return true;
    }

    @Override
    public int atacarDesdeMontura(int jugadorTOP)
    {
        if (this.montura == null) {
            return 0;
        }
        System.out.println("| " + getNombre() + " ataca desde " + this.montura);
        return getDanoAtaque();
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
    public int turnoJinete(int vidaJugador)
    {
        if (montar(getAnimal())) {
            return 0;
        }

        boolean pocaVida = getVidaPorcentaje() < getUmbralMontura();
        if (pocaVida && azar(100) < 50 && desmontar()) {
            System.out.println("| La montura de " + getNombre() + " se asusta por las heridas y no vuelve a montarla");
            return 0;
        }

        int dano = atacarDesdeMontura(vidaJugador);
        if (dano == 0) {
            return -1;
        }
        return dano;
    }
}
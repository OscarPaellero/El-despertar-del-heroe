package VILLANOS;

public class Escudo
{
    private int vidaMax;
    private int vida;
 
    public Escudo(int vidaMax)
    {
        this.vidaMax = vidaMax;
        this.vida = vidaMax;
    }
 
    public int getVida() {
        return this.vida;
    }
 
    public int getVidaMax() {
        return this.vidaMax;
    }
 
    public boolean estaRoto() {
        return this.vida <= 0;
    }
 
    public void recibirDano(int dano)
    {
        this.vida = this.vida - dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }
 
    public void reparar() {
        this.vida = this.vidaMax;
    }
}
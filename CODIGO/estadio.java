public class estadio
{
    private String nombreEstadio;
    private String villano;
    private String heroe;
    private String nombreClub;
    private String arma;
    private String poder;

    public estadio(String estadio, String villano, String heroe, String club, String arma, String poder)
    {
        this.nombreEstadio = estadio;
        this.villano = villano;
        this.heroe = heroe;
        this.nombreClub = club;
        this.arma = arma;
        this.poder = poder;
    }

    //--------------
    public String getEstadio() {
        return this.nombreEstadio;
    }

    public String getVillano() {
        return this.villano;
    }

    public String getHeroe() {
        return this.heroe;
    }

    public String getClub() {
        return this.nombreClub;
    }

    public String getArma() {
        return this.arma;
    }

    public String getPoder() {
        return this.poder;
    }
    //--------------


    public void presentar() 
    {
        System.out.println("¡Bienvenido a " + nombreEstadio + ", el estadio del " + nombreClub);
        System.out.println(" ");
        System.out.println("Pero cuidado, un enemigo ha tomado el control del estadio.");
        System.out.println(" ");
        System.out.println("Tu rival es " + villano + ", una figura no muy bien querida por los aficionados del " + nombreClub);
        System.out.println("Arma de tu adversario: " +arma);
        System.out.println("Poder de tu adversario: " +poder);
        System.out.println(" ");
        System.out.println("Ademas, " + villano + " ha secuestardo a una leyenda del " + nombreClub + ", mas concretamente al historico " + heroe);
        System.out.println(" ");
        System.out.println("Sera muy importante que derrotes a " + villano + " y rescates a " + heroe);
        System.out.println("Y quien sabe, alomejor te ayuda en tus siguientes combates...");


    }
}

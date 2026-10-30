public class estadio
{
    private String nombreEstadio;
    private personaje enemigo; //no es un texto, es un objeto personaje, en este caso h epuesto enemigo
    private personaje heroe; // aqui pasa lo mismo, pero en vez dee enemigo, con heroe
    private String nombreClub;
 

    // Constructor: se ejecuta con "new estadio(...)" y guarda los datos que le quiera pasar
    public estadio(String estadio, personaje enemigo, personaje heroe, String club)
    {
        this.nombreEstadio = estadio;
        this.enemigo = enemigo; 
        this.heroe = heroe; 
        this.nombreClub = club;
    }
 
    public String getEstadio() {
        return this.nombreEstadio;
    }
        public personaje getVillano() {
        return this.enemigo;
    }
    public personaje getHeroe() {
        return this.heroe;
    }
    public String getClub() {
        return this.nombreClub;
    }
 
    public void presentar()
    {
        System.out.println("=================================================== ");
        System.out.println("¡Bienvenido a " + nombreEstadio + ", el estadio del " + nombreClub);
        System.out.println(" ");
        System.out.println("Pero cuidado, un enemigo ha tomado el control del estadio.");
        System.out.println(" ");
        System.out.println("Tu rival es " + enemigo.getNombre() + ", una figura no muy bien querida por los aficionados del " + nombreClub);
        System.out.println("Arma de tu adversario: " + enemigo.getArma().getNombre());
        System.out.println("Poder de tu adversario: " + enemigo.getPoder().getNombre());
        System.out.println(" ");
        System.out.println("Ademas, " + enemigo.getNombre() + " ha secuestardo a una leyenda del " + nombreClub + ", mas concretamente al historico " + heroe.getNombre());
        System.out.println(" ");
        System.out.println("Sera muy importante que derrotes a " + enemigo.getNombre() + " y rescates a " + heroe.getNombre());
        System.out.println("Y quien sabe, alomejor te ayuda en tus siguientes combates...");
        System.out.println("=================================================== ");
        System.out.println(" ");
        System.out.println(" ");

    }
}
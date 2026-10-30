public class personaje extends juego
{
    private String nombre;
    private int vida;
    private arma armaPersonaje;
    private poder poderPersonaje;

    public personaje(String nombre, int vida, arma armaPersonaje, poder poderPersonaje)
    {
        this.nombre = nombre;
        this.vida = vida;
        this.armaPersonaje = armaPersonaje;
        this.poderPersonaje = poderPersonaje;
    }


    public static personaje villanoRoig;
    public static personaje villanoLim;
    public static personaje heroeVilla;
    public static personaje villanoTorres;
    public static personaje villanoLlorente;
    public static personaje villanoDorovic;
    public static personaje heroeBordalas;
    public static personaje heroeMuniain;
    public static personaje heroeAspas;
// ---------------------

    // Me da le nombre de String
    public String getNombre() {
        return this.nombre;
    }

    // Me da l avida en int
    public int getVida() {
        return this.vida;
    }

    // Me da el objeto (arma) del personaje
    public arma getArma() {
        return this.armaPersonaje;
    }

    // Me da le objeto (poder) del persoanje
    public poder getPoder() {
        return this.poderPersonaje;
    }
// ---------------------



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setArma(arma armaPersonaje) {
        this.armaPersonaje  = armaPersonaje ;
    }

    public void setPoder(poder poderPersonaje) {
        this.poderPersonaje  = poderPersonaje ;
    }



    public static personaje villanoRoi =  
    new personaje("Juan Roig", 60, 
    new arma("Ladrillo amarillo", "Te marea y no puedes atacar durante una ronda.", 10),
    new poder("Muro", "+5 de vida a el mismo.", 0));

    public static personaje heroeSenna = new personaje("Marcos Senna", 80,
    new arma("Bote de pastillas", "El bote que nunca se vacia.", 10),
    new poder("Curacion", "Cura a quien lo necesite.", 0));

    public static personaje villanoJoselu = new personaje("Joselu Mato", 60,
    new arma("Poste de porteria", "Hace un x2 en uno de sus ataques.", 10),
    new poder("Descendimiento", "Te quita 5 de vida, de vez en cuando.", 5));

    public static personaje heroeJarque = new personaje("Dani Jarque", 80,
    new arma("Brazalete eterno", "Un brazalete que nunca se rompe.", 10),
    new poder("Eternidad", "Su recuerdo no se apaga.", 0));

    public static personaje villanoPresa = new personaje("Martin Presa", 60,
    new arma("Pelotas de golf", "Sus esbirros tiran enormes cantidades de estas pelotas.", 8),
    new poder("Pelazo de señor", "Te tapa la vision con su pelo y no atacas durante 1 turno.", 0));

    public static personaje heroePalazon = new personaje("Isi Palazon", 80,
    new arma("Rayo de Vallecas", "Un rayo que cae sobre el rival.", 12),
    new poder("Calva luminosa", "Una calva que ciega al rival.", 0));
  
  
  
  
  
    



}




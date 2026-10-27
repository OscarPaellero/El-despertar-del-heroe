public class Personaje
{
    private String nombre;

    public Personaje(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void presentar()
    {
        System.out.println("\n Soy " + this.nombre + " y soy un personaje del Señor de los Anillos");
    }

    public void presentHobbit()
    {
        System.out.println("\n ¡Hola! Soy un Hobbit, por lo que amo la sencillez y la paz, prefiriendo la buena comida, la tranquilidad y una vida sin grandes ambiciones.");
    }

    public void presentElfo()
    {
        System.out.println("\n ¡Saludos! Soy un Elfo, por lo que soy inmortal y vivo en perfecta armonía con la naturaleza y las artes, poseyendo sentidos mucho más agudos que cualquier mortal.");
    }

    public void presentEnano()
    {
        System.out.println("\n ¡Por mi barba! Soy un Enano, por lo que soy extremadamente resistente, orgulloso y apasionado por la minería, la herrería y los tesoros de la tierra.");
    }

    public void presentOrco()
    {
        System.out.println("\n ¡Grrr! Soy un Orco, por lo que estoy corrompido por la oscuridad, viviendo solo para la violencia, el odio y la sumisión a un amo oscuro.");
    }

    public void presentHombre()
    {
        System.out.println("\n ¿Qué tal? Soy un Hombre, por lo que soy mortal, pero esa brevedad me da un libre albedrío absoluto y la ambición para moldear mi propio destino.");
    }

}

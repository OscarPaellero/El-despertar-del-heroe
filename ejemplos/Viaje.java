public class Viaje
{
    public static void main(String[] args)
    {

    // HOBBIT ----------------------------------------

        Hobbit Frodo = new Hobbit( "Frodo",  true);
        Frodo.presentar();
        Frodo.presentHobbit();
        Frodo.ponerAnillo();

        System.out.println("\n");
    
        // -------------------
        
        Hobbit sam = new Hobbit( "Sam",  false);
        sam.presentar();
        sam.presentHobbit();
        sam.ponerAnillo();

        System.out.println("\n");



    // ELFOS ----------------------------------------


        Elfos legolas = new Elfos( "Frodo",  false);
        legolas.presentar();
        legolas.presentElfo();
        legolas.ponerAnillo();

        System.out.println("\n");
    
        // -------------------
        
        Elfos galadriel = new Elfos( "Sam",  false);
        galadriel.presentar();
        galadriel.presentElfo();
        galadriel.ponerAnillo();

        System.out.println("\n");



    // ENANO ----------------------------------------


        Enano Gimli = new Enano( "Gimli",  false);
        Gimli.presentar();
        Gimli.presentEnano();
        Gimli.ponerAnillo();

        System.out.println("\n");
    
        // -------------------
        
        Enano Thorin = new Enano( "Thorin",  false);
        Thorin.presentar();
        Thorin.presentEnano();
        Thorin.ponerAnillo();

        System.out.println("\n");



    // HOMBRE ----------------------------------------


        Hombre Aragorn = new Hombre( "Aragorn",  false);
        Aragorn.presentar();
        Aragorn.presentHombre();
        Aragorn.ponerAnillo();

        System.out.println("\n");
    
        // -------------------
        
        Hombre Isildur = new Hombre( "Isildur",  true);
        Isildur.presentar();
        Isildur.presentHombre();
        Isildur.ponerAnillo();

        System.out.println("\n");



    // Orco ----------------------------------------


        Orco Lurtz = new Orco( "Lurtz",  false);
        Lurtz.presentar();
        Lurtz.presentOrco();
        Lurtz.ponerAnillo();

        System.out.println("\n");
    
        // -------------------
        
        Orco Shagrat = new Orco( "Shagrat",  true);
        Shagrat.presentar();
        Shagrat.presentOrco();
        Shagrat.ponerAnillo();

        System.out.println("\n");
    }
}

package nature;

/**
 * Demo used to manually test the program.
 * 
 * @author 
 * @version 
 */
public class Demo
{
	/**
     * Runs the demo.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Habitat h = new Habitat("asdf",2.0,2.0);
        // for (Animals animal : animals) {
        //     h.addAnimal(animal);
        // }

        Ocelot ocelot = new Ocelot("Ocelot");
        HouseCat houseCat = new HouseCat("HouseCat");
        SiameseCat siameseCat = new SiameseCat("SiameseCat");
        Hippo hippo = new Hippo("Hippo");
        Dog dog = new Dog("Dog");
        Wolf wolf = new Wolf("Wolf");
        Coyote coyote = new Coyote("Coyote");
        Lion lion = new Lion("Lion");

        h.addAnimal(ocelot);
        h.addAnimal(houseCat);
        h.addAnimal(siameseCat);
        h.addAnimal(hippo);
        h.addAnimal(dog);
        h.addAnimal(wolf);
        h.addAnimal(coyote);
        h.addAnimal(lion);
        h.testAnimals();

    }
}

package nature;
import java.util.ArrayList;

public class Habitat {
    // Attributes
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> animals;

    // Constructor
    public Habitat(String name, double lat, double lon) {
        this.name = name;
        this.latitude = lat;
        this.longitude = lon;
        this.animals = new ArrayList<>();
    }

    // Getters
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setLatitude(double lat) {
        this.latitude = lat;
    }

    public void setLongitude(double lon) {
        this.longitude = lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Method to return the number of animals
    public int getNumOfAnimals() {
        return animals.size();
    }

    // Method to add an animal to the habitat
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Method to test and print the list of animals (for debugging or display purposes)
    public void testAnimals() {
        System.out.print(this.name + "\n");
        System.out.print(this.latitude + "\n");
        System.out.print(this.longitude + "\n");
        System.out.print(getNumOfAnimals() + "\n");
        for (Animal animal : animals) 
        {
            animal.sleep();
            animal.makeNoise();
            animal.eat();
            animal.roam();
            if(animal instanceof Pet)
            {
            ((Pet)animal).play();
            ((Pet)animal).beFriendly();
            }
            

        }

        // if (animals.isEmpty()) {
        //     System.out.println("No animals in the habitat.");
        // } else {
        //     System.out.println("Animals in the habitat:");
        //     for (Animal animal : animals) {
        //         System.out.println(animal.toString());
        //     }
        // }
    }
}

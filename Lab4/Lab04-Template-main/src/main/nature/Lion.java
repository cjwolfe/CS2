package nature;

public class Lion extends Feline{

    public Lion(String name)
    {
        super(name);
    }
    public void makeNoise()
    {
        System.out.print("roar ... \n");
    }
    public void eat()
    {
        int x = this.getHungerLevel();
        x--;
        x--;
        this.setHungerLevel(x);
        System.out.print("rip with teeth ... \n");
    }
}

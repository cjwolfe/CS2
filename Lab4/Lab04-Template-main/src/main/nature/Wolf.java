package nature;

public class Wolf extends Canine{
    public Wolf(String name)
    {
        super(name);
    }
    @Override
    public void eat()
    {
        int x = this.getHungerLevel();
        x--;
        x--;
        this.setHungerLevel(x);
        System.out.print("rip with teeth ... \n");
    }
    @Override
    public void makeNoise()
    {
        System.out.print("growl ... \n");
    }
}

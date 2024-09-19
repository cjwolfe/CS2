package nature;

public class Hippo extends Animal{

    public Hippo(String name)
    {
    super(name);
    }
    @Override
    public void eat()
    {
        int x = this.getHungerLevel();
        x--;
        this.setHungerLevel(x);
        System.out.print("slurp ... \n");
    }
    @Override
    public void makeNoise()
    {
        System.out.print("blub ... \n");
    }
}

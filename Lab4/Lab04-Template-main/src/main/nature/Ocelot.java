package nature;

public class Ocelot extends Feline{

    public Ocelot(String name)
    {
        super(name);
    }
    @Override
    public void eat()
    {
        int x = this.getHungerLevel();
        x--;
        x--;
        x--;
        this.setHungerLevel(x);
        System.out.print("pick ... \n");
    }
    // @Override
    // public void makeNoise()
    // {
    //     //System.out.print("blub ... ");
    // }
}

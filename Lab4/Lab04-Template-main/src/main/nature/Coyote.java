package nature;

public class Coyote extends Canine{

    public Coyote(String name)
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
        System.out.print("gnaws ... \n");
    }
    @Override
    public void makeNoise()
    {
        System.out.print("howl ... \n");
    }
}

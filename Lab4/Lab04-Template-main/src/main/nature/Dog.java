package nature;

public class Dog extends Canine implements Pet{
    public Dog(String name)
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
        System.out.print("slop ... \n");
    }
    @Override
    public void makeNoise()
    {
        System.out.print("bark ... \n");
    }
    @Override
    public void play()
    {
        System.out.print("runs ... \n");
    }
    @Override
    public void beFriendly()
    {
        System.out.print("nuzzles ... ");
    }

}

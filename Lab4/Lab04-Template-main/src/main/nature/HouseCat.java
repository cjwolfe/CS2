package nature;

public class HouseCat extends Feline implements Pet{
    public HouseCat(String name)
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
        System.out.print("crunch crunch ... \n");
    }
    @Override
    public void play()
    {
        System.out.print("frolic ...\n");
    }
    @Override
    public void beFriendly()
    {
        System.out.print("purr ...\n");
    }
}

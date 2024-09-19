package nature;

public abstract class Feline extends Animal
{
    public Feline(String name)
    {
        super(name);
    }
    @Override
    public void roam()
    {
        int x = this.getHungerLevel();
        x++;
        this.setHungerLevel(x);
        System.out.print("felines like to roam alone ... \n");
    }
    @Override
    public void sleep()
    {
        this.setHungerLevel(Integer.MAX_VALUE);
        System.out.print("taking a cat nap ... \n");
    }
    @Override
    public void makeNoise()
    {
        System.out.print("meow ... \n");
    }

}

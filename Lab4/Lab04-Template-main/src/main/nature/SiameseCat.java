package nature;

public class SiameseCat extends HouseCat{

    public SiameseCat(String name)
    {
        super(name);
    }
    @Override
    public void makeNoise()
    {
        System.out.print("mrrooowwww ...\n");
    }
    @Override
    public void play()
    {
        System.out.print("zoom zoom zoom ...\n");
    }

}

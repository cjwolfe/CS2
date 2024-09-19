package nature;

public abstract class Canine extends Animal {
    public Canine(String name){
        super(name);
    }
    @Override
    public void roam()
    {
        int x = this.getHungerLevel();
        x++;
        this.setHungerLevel(x);
        System.out.print("like canines roam in packs ... \n");
    }

}

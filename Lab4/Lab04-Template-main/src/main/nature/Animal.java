package nature;
public abstract class Animal 
{
    protected String name;
    protected int hungerLevel;

    public Animal(String name)
    {
        this.name = name;
        this.hungerLevel = 0;
    }

    public int getHungerLevel()
    {
        return this.hungerLevel;
    }

    public String getName()
    {
        return this.name;
    }
    
    public void setHungerLevel(int hungerLevel)
    {
        
        if (hungerLevel <=0)
        {
            this.hungerLevel = 0;
        }
        else if (hungerLevel >=10) 
        {
            this.hungerLevel = 10;
        }
        else 
        {
            this.hungerLevel = hungerLevel;
        }
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void sleep()
    {
        
        this.setHungerLevel(10);
        System.out.print("sleeping ... \n");

    }
    public void roam()
    {
        int x = this.getHungerLevel();
        x++;
        this.setHungerLevel(x);
        System.out.print("moving around ... \n");
    }
    public abstract void eat();

    public abstract void makeNoise();

}

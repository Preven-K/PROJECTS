package LIBRARY;
import java.io.Serializable;

class Patron implements Serializable           //used to convert object to stream of bytes to storing purpose

{
    private String name;

    // setters and getters

    public Patron(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
}
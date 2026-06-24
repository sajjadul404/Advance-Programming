package University;
import Library.*;
class Academy //default class
{
    public int a;
    private int b;
    protected int c;


    Academy(int a,int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;

    }
    void display()
    {
        System.out.println("a: "+a+"b: "+b+"c: "+c);
    }

}

/*public class FirstClass extends demo1 {

    public static void main(String[] args)
    {
        Academy ac = new Academy(1,2,3);
        ac.display();
        //int z = ac.b; //not possible due to variable b being private
       // System.out.println("z: "+z);
    }
}*/

public class FirstClass extends SecondClass{

    public static void main(String[] args)
    {
        Academy ac = new Academy(1,2,3);
        ac.display();
        FirstClass a = new FirstClass();
        a.something();
        //default access
        //int z = ac.b; //not possible due to variable b being private
        // System.out.println("z: "+z);
    }
}

class Box
{
    double length,width;
    Box()
    {
        length = 3;
        width = 4;
    }
    Box(double len)
    {
        length = width = len;
    }
    Box(double length,double width)
    {
        this.length = length;
        this.width = width;
    }
    Box(Box b)
    {
        this.length = b.length;
        this.width = b.width;
    }
    void display()
    {
        System.out.println("Box length: "+length+" Box width: "+width);
    }
}
class Main
{
    public static void main(String args[])
    {
        Box b1 = new Box();
        Box b2 = new Box(12);
        Box b3 = new Box(13,34);
        Box b4 = new Box(b2);
        b1.display();
        b2.display();
        b3.display();
        b4.display();

    }
}

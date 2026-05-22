class Line
{
    int point1,point2;
    Line()
    {
        point1 = 10;
        point2 = 2;
    }
    Line(int point1,int point2)
    {
        this.point1 = point1;
        this.point2 = point2;
    }
    void display()
    {
        System.out.println("Point1: "+point1+" Point2: "+point2);
    }
}
class Main
{
    public static void main(String args[])
    {
        Line l1[] = new Line[3];
        for(int i=0;i<l1.length;i++)
        {
            l1[i]=new Line();
        }
        for(int i=0;i<l1.length;i++)
        {
            l1[i].display();
        }

    }
}

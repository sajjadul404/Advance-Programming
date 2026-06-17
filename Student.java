class Student
{
    String name;
    int roll;
    Student(String name,int roll)
    {
        this.name = name;
        this.roll = roll;
    }
    Student(int roll,String name)
    {
        this.name = name;
        this.roll = roll;
    }
    void display()
    {
        System.out.println("Student name: "+name+" "+"Roll: "+roll);
    }
}
class Main{
        public static void main(String args[])
    {
        Student s1=new Student("ABC",3);
        Student s2 = new Student(12,"VBD");
        s1.display();
        s2.display();
    }
}
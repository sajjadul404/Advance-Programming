package GranderFather;
class Grandfather {
    int age;
    String name;

    Grandfather(int age, String name) {
        this.age = age; 
        this.name = name;

        System.out.println("Grandfather Details:");
        System.out.println("Name: " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println();
    }
}

class Father extends Grandfather {

    Father(int age, String name) {
        super(age, name); 

        System.out.println("Father Details:");
        System.out.println("Name: " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println();
    }
}

class Son extends Father {

    Son(int age, String name) {
        super(age, name); 

        System.out.println("Son Details:");
        System.out.println("Name: " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Son s = new Son(20, "Rahim");

    }
}
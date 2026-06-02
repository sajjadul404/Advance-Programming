package Smartphone;

class Smartphone {
    private String brand;
    private String model;
    private int storageCapacity;


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void increaseStorage(int value) {
        storageCapacity += value;
    }
}

public class Main {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone();

      
        phone.setBrand("Samsung");
        phone.setModel("Galaxy S24");
        phone.setStorageCapacity(128);

        System.out.println("Brand: " + phone.getBrand());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Storage Capacity: " + phone.getStorageCapacity() + " GB");

        phone.increaseStorage(64);

        System.out.println("Updated Storage Capacity: " + phone.getStorageCapacity() + " GB");
    }
}
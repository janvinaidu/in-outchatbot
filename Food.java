class Food {
    String name;
    double price;
    String type;
//
    //creates my food item
    public Food(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

   
    public void displayInfo() {
        System.out.println(name + " - $" + price + " - Type: " + type);
    }
}
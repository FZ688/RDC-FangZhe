package week1_Implements;

public class Cook {
    public static void main(String[] args) {
        Dish dish1 = new Tofu();
        dish1.cook();
        dish1.serve();
        System.out.println("----------------------------");

        Dish dish2 = new Carrot();
        dish2.cook();
        dish2.serve();

    }
}

package week1_Extends;

public class Cook {
    public static void main(String[] args) {
        Dish d1 = new Tofu("葱爆豆腐","葱和豆腐",10,5.50);
        d1.cook();
        d1.serve();
        System.out.println("--------------------------------------------------------------");
        
        Dish d2 = new Carrot("爆炒胡萝卜","胡萝卜和辣椒",8,"红色");
        d2.cook();
        d2.serve();
    }
}

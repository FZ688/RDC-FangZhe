package week1_Extends;

public class Tofu extends Dish{
    private double price; //成本价
    public Tofu() {
        super();
    }
    public Tofu(double price) {
        this.price = price;
    }

    public Tofu(String name, String ingredients, long time, double price) {
        super(name, ingredients, time);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void cook() {
        System.out.println("这道菜的成本价是： " + price);
        System.out.println("正在煮 " + getName() + " ，配料是： " + getIngredients() + "，需要花费  " + getTime() + " 分钟.");
    }

    @Override
    public void serve() {
        System.out.println("为您上菜，这是葱煎豆腐~~");
    }
    //特有方法
    public void congJian(){
        System.out.println("葱煎葱煎~~");
    }
}

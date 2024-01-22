package week1_Extends;

public class Carrot extends Dish{
    private String color;
    public Carrot() {
        super();
    }
    public Carrot(String color) {
        this.color = color;
    }

    public Carrot(String name, String ingredients, long time, String color) {
        super(name, ingredients, time);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void cook() {
        System.out.println("正在煮 " + getName() + " ，配料是： " + getIngredients() + "，需要花费  " + getTime() + " 分钟.");
        System.out.println("这道菜的颜色是： " + color);
    }

    @Override
    public void serve() {
        System.out.println("为您上菜,这是爆炒胡萝卜~");
    }

    //特有方法
    public void fire(){
        System.out.println("爆炒爆炒爆炒~~~");
    }
}

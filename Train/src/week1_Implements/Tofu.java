package week1_Implements;

public class Tofu implements Dish{

    @Override
    public void cook() {
        System.out.println("正在做葱煎豆腐中.....");
    }

    @Override
    public void serve() {
        System.out.println("您的葱煎豆腐做好了~");
    }
}

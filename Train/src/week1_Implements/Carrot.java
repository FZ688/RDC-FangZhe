package week1_Implements;

public class Carrot implements Dish{

    @Override
    public void cook() {
        System.out.println("正在做暴炒胡萝卜...");
    }

    @Override
    public void serve() {
        System.out.println("您的爆炒胡萝卜做好了~");
    }
}

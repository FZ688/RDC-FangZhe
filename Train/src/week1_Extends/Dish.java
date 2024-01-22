package week1_Extends;

public class Dish {
    private String name; //菜名
    private String ingredients; //配料
    private long time; //烹饪时间

    public Dish() {
    }

    public Dish(String name, String ingredients, long time) {
        this.name = name;
        this.ingredients = ingredients;
        this.time = time;
    }

    public String getName() {
        return name;
    }
    public String getIngredients() {
        return ingredients;
    }
    public long getTime() {
        return time;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public void setTime(long time) {
        this.time = time;
    }

    //煮
    public void cook() {
        System.out.println("正在煮 " + name + " ，配料是： " + ingredients + "，需要花费  " + time + " 分钟.");
    }

    //上菜
    public void serve() {
        System.out.println("请享用");
    }
}

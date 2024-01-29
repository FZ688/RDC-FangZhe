package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author fz
 */
public class Demo {
    public static void main(String[] args) {
       /*
        假设X=30,N=3,M=5;
        一周内吃超过X元的食物不能超过N次;
        一周内吃重复食物的次数不能超过M次;
        */
        List<Food> foods = new ArrayList<>();
        Food food1 = new Food( "牛肉面", 20.6);
        Food food2 = new Food( "塔斯汀", 30.8);
        Food food3 = new Food( "杀猪粉", 20.8);
        Food food4 = new Food( "鸡公煲", 45.8);
        Food food5 = new Food( "多乐福", 26.5);
        Food food6 = new Food("关东煮", 10.5);
        Collections.addAll(foods,food1,food2,food3,food4,food5,food6);


        /*
          用Map集合的值来统计吃的次数
          用List集合来存入生成一周午餐和晚餐的食物
         */
        Map<Food,Integer> statistic = new HashMap<>();
        List<Food> oneWeekFood =  new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 14; i++) {
            //随机数决定吃什么
            int index = r.nextInt(foods.size());
            Food randomFood = foods.get(index);
            if (statistic.get(randomFood) == null){
                statistic.put(randomFood,1);
                oneWeekFood.add(randomFood);
            }else {
                //一周内吃重复食物的次数不能超过5次
                // 价格超过30元的所有食物的次数不能超过3次
                while (statistic.get(randomFood) >= 5 ||
                        (foods.get(index).getPrice() > 30 && priceBeyond30(oneWeekFood)>=3)){
                    index = r.nextInt(foods.size());
                    randomFood = foods.get(index);
                }
                statistic.put(randomFood,statistic.get(randomFood)+1);
                oneWeekFood.add(randomFood);
            }
        }

        /*
         将装有一周食物的List集合里的元素分发给7天的集合
        */
        List<Food> mondayFood = new ArrayList<>();
        List<Food> tuesdayFood = new ArrayList<>();
        List<Food> wednesdayFood = new ArrayList<>();
        List<Food> thursdayFood = new ArrayList<>();
        List<Food> fridayFood = new ArrayList<>();
        List<Food> saturdayFood = new ArrayList<>();
        List<Food> sundayFood = new ArrayList<>();
        for (int i = 0; i < oneWeekFood.size()/2; i++) {
            for (int j = 0; j < 2; j++) {
                Food food = oneWeekFood.get(i*2+j);
                switch (i){
                    case 0:
                        mondayFood.add(food);
                        break;
                    case 1:
                        tuesdayFood.add(food);
                        break;
                    case 2:
                        wednesdayFood.add(food);
                        break;
                    case 3:
                        thursdayFood.add(food);
                        break;
                    case 4:
                        fridayFood.add(food);
                        break;
                    case 5:
                        saturdayFood.add(food);
                        break;
                    case 6:
                        sundayFood.add(food);
                        break;
                    default:
                        break;
                }
            }
        }

        /*
        打算搞个集合嵌套创建那张食物清单
        */
        Map<String,List<Food>> foodList = new LinkedHashMap<>();
        foodList.put("周一",mondayFood);
        foodList.put("周二",tuesdayFood);
        foodList.put("周三",wednesdayFood);
        foodList.put("周四",thursdayFood);
        foodList.put("周五",fridayFood);
        foodList.put("周六",saturdayFood);
        foodList.put("周日",sundayFood);

        //打印清单
        foodList.forEach((d,f)->{
            System.out.println(d+"："+toString(f));
        });

    }

        /**
         *统计超过价格超过30元的食物的数量
         */
        public static int priceBeyond30(List<Food> foods){
            int count = 0;
            for (Food food : foods) {
                if (food.getPrice() > 30){
                    count++;
                }
            }
            return count;
        }

        /**
        * 自己懒得想模板，就按师兄的来
        */
        public static String toString(List<Food> foods){
            StringBuffer strBack = new StringBuffer();
            for (Food food : foods) {
                String str = food.getName()+"："+food.getPrice()+"元  ";
                strBack.append(str);
            }
            return strBack.toString();
        }


}

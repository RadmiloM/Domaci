import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

public class Test {
    public static void main(String[] args) {
        FoodDaoSQL fd = new FoodDaoSQL();
        FoodModel food = new FoodModel(1,"Ajvar",22.4,33.1,12.5,11.4);
        MealModelSQL md = new MealModelSQL();
        MealModel meal = new MealModel(1,"Pica sa susamom","jedi uz salatu","light");
        MealModel meal2 = new MealModel(2,"Palacinke sa kremom","Ispeci na visokoj temperaturi","middlelight");
        MealModel meal3 = new MealModel(3,"Sarma sa zeljem","jesti sa jogurtom","light");
        MealModel meal4 = new MealModel(4,"Cevapi","Kuvati na ulju","hard");
        meal.setMealName("Pljeskavica sa kupusom");
        FoodModel foodTwo = new FoodModel(2,"Salama",11.4,45.6,17.7,18.6);
        FoodModel foodThree = new FoodModel(3,"Jaja sa cvarcima",22.4,33.1,12.3,22.1);
        System.out.println(md.getAllMeals());
        System.out.println(fd.getAllFood());
        fd.addToMeal(1,1,22);


    }
}

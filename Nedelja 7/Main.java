import rs.itbootcamp.dao.FoodDao;
import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;
import rs.itbootcamp.model.MealModel;

import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static FoodDao fd = new FoodDaoSQL();
    static FridgeDaoSQL fridge = new FridgeDaoSQL();
    static MealModelSQL mealsModel = new MealModelSQL();
    static int fridge_id = 1;

    private static void welcomeMessage() {
        System.out.println("Welcome to kitchen!!!");
        System.out.println("------------------------");
    }


    // 1.Enter word or more words
    // 2.Print word or more words which are in the name
    // or description in meal.
    private static void Search(Scanner sc) {
        System.out.println("Welcome to the meal search");
        List<MealModel> meals = mealsModel.getAllMeals();
        String letters;
        String containWords ="";
        int number = 1;
        do {
            letters = sc.nextLine();
            for (MealModel meal : meals) {
                if (meal.getMealName().contains(letters) || meal.getMealDescription().contains(letters)) {
                    if (!containWords.contains(letters)) {
                        containWords += number + "." + letters + "\n";
                        number++;
                    }

                }
            }
            System.out.println(containWords);
            System.out.println("Enter word,words or (Exit) to stop the search: ");
        }
        while (!letters.equals("Exit")); {

        }
    }













    private static void addFoodToFridge(Scanner sc){
        List<FoodModel> foodList = fd.getAllFood();
        int choice = -1;

        while(choice != 0){
            for(int i = 0; i < foodList.size(); i++){
                System.out.println((i+1) + ". " + foodList.get(i));
            }
            System.out.println("0. Back");

            choice = sc.nextInt();

            if(choice > 0 && choice <= foodList.size()){
                System.out.println("How much: (in grams)");
                int mass = sc.nextInt();
                fd.addToFridge(fridge_id,foodList.get(choice - 1).getFood_id(),mass);
                System.out.println("++");
            }
        }
    }

    private static void fridgeMenu(Scanner sc){
        int choice;
        do{
            System.out.println("My Fridge:");
            System.out.println("--------");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Look in");
            System.out.println("4. Create meal");
            System.out.println("0. Back");

            choice = sc.nextInt();

            switch(choice){
                case 1 -> addFoodToFridge(sc);
                case 2 -> System.out.println("Remove food from fridge");
                case 3 -> System.out.println("Write all food from fridge");
                case 4 -> System.out.println("Create meal");
                case 0 -> System.out.println();
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    private static void mainMenu(Scanner sc){
        int choice;
        do{
            System.out.println("Main menu:");
            System.out.println("-----------");
            System.out.println("1. My Fridge");
            System.out.println("2. Meals");
            System.out.println("3. All food");
            System.out.println("4. Add new food");
            System.out.println("5. Search");
            System.out.println("0. Exit");

            choice = sc.nextInt();

            switch (choice){
                case 1 -> fridgeMenu(sc);
                case 2 -> System.out.println("Meals");
                case 3 -> System.out.println("All food");
                case 4 -> System.out.println("Add new food");
                case 5 -> Search(sc);
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while(choice != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        welcomeMessage();

        mainMenu(sc);
    }
}
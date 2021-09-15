import com.sun.jdi.Value;
import rs.itbootcamp.dao.MealDao;
import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealModelSQL implements MealDao {
    private static final Connection conn = DatabaseConnection.getConnection();

    @Override
    public void insert(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO meal " + "VALUES(?,?,?,?)");
            st.setInt(1, mm.getMealId());
            st.setString(2, mm.getMealName());
            st.setString(3, mm.getMealDescription());
            st.setString(4, mm.getMealDifficulty());
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM meal WHERE meal_id = ?");
            st.setInt(1, 1);
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(MealModel mm) {
        try {
            PreparedStatement st = conn.prepareStatement("Update meal " +
                    "SET meal_id = ?, " +
                    "meal_name= ?, " +
                    "meal_desc= ?, " +
                    "meal_difficulty = ? " +
                    "WHERE meal_id = ?");
            st.setInt(1, mm.getMealId());
            st.setString(2, mm.getMealName());
            st.setString(3, mm.getMealDescription());
            st.setString(4, mm.getMealDifficulty());
            st.setInt(5, mm.getMealId());
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    // Ovaj upit nece raditi ne pokretati
    @Override
    public MealModel getMeal(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT meal_name FROM meal\n" +
                    "WHERE meal_id = ?");
            while (rs.next()) {
                int id_meal = rs.getInt(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                String difficulty = rs.getString(4);

                MealModel m = new MealModel(id_meal, name, description, difficulty);
                return m;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }

    @Override
    public List<MealModel> getAllMeals() {
        List<MealModel> listOfmeals = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal ");
            while (rs.next()) {
                MealModel meal = new MealModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)

                );
                listOfmeals.add(meal);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listOfmeals;

    }
    // Ovaj upit nece raditi.
    @Override
    public List<String> getFoodMealNames(int meal_id) {
        List<String> names = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal\n" +
                    "CROSS JOIN food WHERE meal_id = ? ");
            while (rs.next()) {
                String food_name = rs.getString(2);
                String meal_name = rs.getString(6);

                names.add(food_name);
                names.add(meal_name);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return names;


    }
    // Ovaj upit nece raditi
    @Override
    public List<FoodModel> getFoodModel(int meal_id) {
        List<FoodModel> food = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food\n" +
                    "INNER JOIN mealfood ON mealfood.food_id = food.food_id\n" +
                    "INNER JOIN meal ON meal.meal_id = mealfood.meal_id\n" +
                    "WHERE meal_id = ?;\n");
            while(rs.next()) {
                FoodModel f = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)
                );
                food.add(f);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return food;
    }
}

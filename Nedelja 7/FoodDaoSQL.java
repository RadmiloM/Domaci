package rs.itbootcamp.dao;

import rs.itbootcamp.database.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoSQL implements FoodDao {
    private static final Connection conn = DatabaseConnection.getConnection();
    @Override
    public void insert(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO food " + "VALUES(?,?,?,?,?,?)");
            st.setInt(1,fm.getFood_id());
            st.setString(2,fm.getFood_name());
            st.setDouble(3,fm.getFood_kcal());
            st.setDouble(4,fm.getFood_proteins());
            st.setDouble(5,fm.getFood_carbohydrates());
            st.setDouble(6,fm.getFood_fat());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // ovaj upit nece raditi
    @Override
    public void addToMeal(int meal_id, int food_id, int mass) {
        try {
            PreparedStatement st =conn.prepareStatement("INSERT INTO mealfood" + "VALUES(?,?,?)");
            st.setInt(1,meal_id);
            st.setInt(2,food_id);
            st.setDouble(3,mass);
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM food WHERE food_id = ?");
            st.setInt(1,1);
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void update(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE food " +
                    "SET food_id = ?, " +
                    "food_name = ?, " +
                    "food_kcal = ?, " +
                    "food_proteins= ?, " +
                    "food_carbs = ?, " +
                    "food_fat= ? " +
                    "WHERE food_id = ?");
            st.setInt(1,fm.getFood_id());
            st.setString(2,fm.getFood_name());
            st.setDouble(3,fm.getFood_kcal());
            st.setDouble(4,fm.getFood_proteins());
            st.setDouble(5,fm.getFood_carbohydrates());
            st.setDouble(6,fm.getFood_fat());
            st.setInt(7,fm.getFood_id());
            st.executeUpdate();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public FoodModel getFood(int id) {
        return null;
    }

    @Override
    public List<FoodModel> getAllFood() {
        List<FoodModel> allFood = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food ");
            while(rs.next()){
                FoodModel newFood = new FoodModel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getDouble(5),
                        rs.getDouble(6)

                );
                allFood.add(newFood);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allFood;
    }

}

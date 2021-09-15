package rs.itbootcamp.model;

public class MealModel {
    private int mealId;
    private String mealName;
    private String mealDescription;
    private String mealDifficulty;

    public MealModel(int mealId, String mealName, String mealDescription, String mealDifficulty) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealDifficulty = mealDifficulty;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public String getMealDifficulty() {
        return mealDifficulty;
    }

    public void setMealDifficulty(String mealDifficulty) {
        this.mealDifficulty = mealDifficulty;
    }

    @Override
    public String toString() {
        return "MealModel{" +
                "mealId=" + mealId +
                ", mealName='" + mealName + '\'' +
                ", mealDescription='" + mealDescription + '\'' +
                ", mealDifficulty='" + mealDifficulty + '\'' +
                '}';
    }
}

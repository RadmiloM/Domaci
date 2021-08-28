public class WaterPokemon extends  Pokemon{

    public WaterPokemon(String name, int health) {
        super(name, name , health);
    }

    @Override
    public String logAll() {
        String log = "";
        log = log + "Attack: " + attack() + "\n"
                + "Defend: " + defend() + "\n"
                + "Winning against: " + winningAgainst() + "\n"
                + "Losing against: " + losingFrom() + "\n";
        return log;
    }

    @Override
    public String attack() {
        return "Attack with water";
    }

    @Override
    public String defend() {
        return "With water";
    }

    @Override
    public String winningAgainst() {
        return "Fire type";
    }

    @Override
    public String losingFrom() {
        return "Grass type";
    }
}

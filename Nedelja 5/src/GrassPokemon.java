public class GrassPokemon extends Pokemon{
    public GrassPokemon(String name, int health) {
        super(name, name, health);
    }

    @Override
    public String logAll() {
        String log = "";
        log = log + "Attack: " + attack() + "\n" + "Defend: "
                + defend() + "\n"
                + "Winning against: " +  winningAgainst() + "\n"
                + "Losing from: " + losingFrom() + "\n";

        return log;
    }

    @Override
    public String attack() {
        return "Attack with grass";
    }

    @Override
    public String defend() {
        return "Avoiding the combat";
    }

    @Override
    public String winningAgainst() {
        return "Water type";
    }

    @Override
    public String losingFrom() {
        return "Fire type";
    }
}

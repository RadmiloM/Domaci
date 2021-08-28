public class FirePokemon extends Pokemon{
    public FirePokemon(String name,int health) {
        super(name, name, health);
    }

    @Override
    public String logAll() {
        String log = "";
        log = log + "Attack: " + attack() + "\n"
                + "Defend: " + defend() + "\n"
                + "Winning against: " + winningAgainst() + "\n"
                + "Losing from: " + losingFrom() + "\n";
        return log;
    }

    @Override
    public String attack() {
        return "Attack with fire";
    }

    @Override
    public String defend() {
        return "Defending physically";
    }

    @Override
    public String winningAgainst() {
        return "Grass type";
    }

    @Override
    public String losingFrom() {
        return "Water type";
    }
}

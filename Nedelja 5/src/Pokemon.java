public abstract  class Pokemon implements PokemonTypes{
    private String name,type;
    private int health;

    public Pokemon(String name, String type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
    }

    public abstract  String logAll();
}

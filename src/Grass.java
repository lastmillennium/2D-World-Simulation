public class Grass extends Entity{
    Grass(Position position) {
        super(position);
    }
    @Override
    boolean isEdibleBy(Creature creature) {
        return creature instanceof Herbivore;
    }
    public String toString() {
        return "\uD83C\uDF3F";
    }
}

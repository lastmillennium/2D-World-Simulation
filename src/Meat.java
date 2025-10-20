public class Meat extends Entity {
    Meat(Position position) {
        super(position);
    }
    @Override
    boolean isEdibleBy(Creature creature) {
        return creature instanceof Predator;
    }
    @Override
    public String toString() {
        return "\uD83E\uDD69";
    }
}

public class Herbivore extends Creature {
    Herbivore(Position position) {
        super(position);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC2E";
    }
    @Override
    boolean isEdibleBy(Creature creature) {
        return creature instanceof Predator;
    }
}

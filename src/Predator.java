public class Predator extends Creature {
    Predator(Position position) {
        super(position);
    }
    @Override
    boolean isEdibleBy(Creature creature) {
        return false;
    }
    @Override
    void makeMove(World world, Actions actions) {
        actions.makeMove(world, this);
    }
    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }
}

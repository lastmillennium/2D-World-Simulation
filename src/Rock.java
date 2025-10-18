public class Rock extends Entity{
    Rock(Position position) {
        super(position);
    }
    @Override
    boolean isEdibleBy(Creature creature) {
        return false;
    }
    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }
}

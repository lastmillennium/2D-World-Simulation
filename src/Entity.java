public abstract class Entity {
    Position position;
    Entity(Position position) {
        this.position = position;
    }
    abstract boolean isEdibleBy(Creature creature);
}
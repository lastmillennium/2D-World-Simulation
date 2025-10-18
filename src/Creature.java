public abstract class Creature extends Entity {
    Creature(Position position) {
        super(position);
    }
    abstract void makeMove(World world, Actions actions);
}
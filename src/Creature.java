import java.util.Map;

public abstract class Creature extends Entity {
    Creature(Position position) {
        super(position);
    }
    void makeMove(World world) {
        Position oldPosition = this.position;
        Position foodPosition = world.foodPosition(oldPosition, this);
        Map<Position, Position> cleanPath = world.pathToFood(world.wayToFoodSearch(oldPosition, this), foodPosition);
        Position newPosition = world.getNextStep(cleanPath, oldPosition);
        if (world.isGoingAbroad(newPosition)) {
            world.world.remove(oldPosition);
            world.world.put(newPosition, this);
            this.position = newPosition;
        }
    }
}
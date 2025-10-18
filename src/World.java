import java.util.HashMap;
import java.util.Map;
public class World {
    final int width = 10;
    final int depth = 10;
    Map<Position, Entity> world = new HashMap<>();
    void setEntity(Position position, Entity entity) {
        entity.position = position;
        world.put(position, entity);
    }
    void setupDefaultEntitiesPosition() {
        setEntity(new Position(1, 7), new Rock(new Position(1, 7)));
        setEntity(new Position(0, 1), new Rock(new Position(0, 1)));
        setEntity(new Position(1, 1), new Rock(new Position(1, 1)));
        setEntity(new Position(2, 4), new Rock(new Position(2, 4)));
        setEntity(new Position(7, 4), new Rock(new Position(7, 4)));
        setEntity(new Position(5, 1), new Rock(new Position(5, 1)));
        setEntity(new Position(2, 1), new Grass(new Position(2, 1)));
        setEntity(new Position(8, 2), new Grass(new Position(8, 2)));
        setEntity(new Position(2, 1), new Grass(new Position(2, 2)));
        setEntity(new Position(0, 5), new Grass(new Position(0, 5)));
        setEntity(new Position(0, 0), new Herbivore(new Position(0, 0)));
        setEntity(new Position(5, 5), new Herbivore(new Position(5, 5)));
        setEntity(new Position(7, 7), new Predator(new Position(7, 7)));
    }
    boolean isGoingAbroad (Position position) {
        return position.x >= 0 && position.x < width
                && position.y >= 0 && position.y < depth
                && !(world.get(position) instanceof Rock);
    }
}

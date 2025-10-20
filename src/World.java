import java.util.*;

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
    boolean isGoingAbroad(Position position) {
        return position.x >= 0 && position.x < width
                && position.y >= 0 && position.y < depth
                && !(world.get(position) instanceof Rock);
    }
    boolean isAnybodyHere(Position position) {
        return world.get(position) instanceof Creature;
    }
    Map<Position, Position> wayToFoodSearch(Position start, Creature creature) {
        Queue<Position> Edible = new LinkedList<>();
        Map<Position, Position> previousPosition = new LinkedHashMap<>();
        Set<Position> searched = new HashSet<>();
        Edible.add(start);
        searched.add(start);
        while (!Edible.isEmpty()) {
            Position possiblePos = Edible.remove();
            if (world.get(possiblePos) != null && world.get(possiblePos).isEdibleBy(creature)) {
                return previousPosition;
            } else {
                Position up = new Position(possiblePos.x, possiblePos.y - 1);
                Position down = new Position(possiblePos.x, possiblePos.y + 1);
                Position left = new Position(possiblePos.x - 1, possiblePos.y);
                Position right = new Position(possiblePos.x + 1, possiblePos.y);
                if (isGoingAbroad(up) && !searched.contains(up)) {
                    Edible.add(up);
                    searched.add(up);
                    previousPosition.put(up, possiblePos);
                }
                if (isGoingAbroad(down) && !searched.contains(down)) {
                    Edible.add(down);
                    searched.add(down);
                    previousPosition.put(down, possiblePos);
                }
                if (isGoingAbroad(left) && !searched.contains(left)) {
                    Edible.add(left);
                    searched.add(left);
                    previousPosition.put(left, possiblePos);
                }
                if (isGoingAbroad(right) && !searched.contains(right)) {
                    Edible.add(right);
                    searched.add(right);
                    previousPosition.put(right, possiblePos);
                }
            }
        }
        return null;
    }
    Position foodPosition(Position start, Creature creature) {
        Queue<Position> Edible = new LinkedList<>();
        Set<Position> searched = new HashSet<>();
        Edible.add(start);
        searched.add(start);
        while (!Edible.isEmpty()) {
            Position possiblePos = Edible.remove();
            if (world.get(possiblePos) != null && world.get(possiblePos).isEdibleBy(creature)) {
                return possiblePos;
            } else {
                Position up = new Position(possiblePos.x, possiblePos.y - 1);
                Position down = new Position(possiblePos.x, possiblePos.y + 1);
                Position left = new Position(possiblePos.x - 1, possiblePos.y);
                Position right = new Position(possiblePos.x + 1, possiblePos.y);
                if (isGoingAbroad(up) && !searched.contains(up)) {
                    Edible.add(up);
                    searched.add(up);
                }
                if (isGoingAbroad(down) && !searched.contains(down)) {
                    Edible.add(down);
                    searched.add(down);
                }
                if (isGoingAbroad(left) && !searched.contains(left)) {
                    Edible.add(left);
                    searched.add(left);
                }
                if (isGoingAbroad(right) && !searched.contains(right)) {
                    Edible.add(right);
                    searched.add(right);
                }
            }
        }
        return null;
    }
    Map<Position, Position> pathToFood(Map<Position, Position> dirtPath, Position end) {
        Map<Position, Position> clean = new LinkedHashMap<>();
        Position current = end;
        Position parent;
        while (current != null) {
            parent = dirtPath.get(current);
            if (dirtPath.containsKey(current)) {
                clean.put(current, parent);
            }
            current = parent;
        }
        return clean;
    }
    Position getNextStep(Map<Position, Position> path, Position start) {
        Position next = start;
        for (Map.Entry<Position, Position> entry : path.entrySet()) {
            if (entry.getValue().equals(start)) {
                next = entry.getKey();
            }
        }
        return next;
    }
}

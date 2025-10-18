import java.util.*;
public class Actions {
void makeMove(World world, Creature creature) {
    Position oldPosition = creature.position;
    Position foodPosition = foodPosition(world, oldPosition, creature);
    Map<Position, Position> cleanPath = pathToFood(wayToFoodSearch(world, oldPosition, creature), foodPosition);
    Position newPosition = getNextStep(cleanPath, oldPosition);
    if (world.isGoingAbroad(newPosition)) {
        world.world.remove(oldPosition);
        world.world.put(newPosition, creature);
        creature.position = newPosition;
    }
}
Map<Position, Position> wayToFoodSearch(World world, Position start, Creature creature) {
    Queue<Position> Edible = new LinkedList<>();
    Map<Position, Position> previousPosition = new LinkedHashMap<>();
    Set<Position> searched = new HashSet<>();
    Edible.add(start);
    searched.add(start);
    while (!Edible.isEmpty()) {
        Position possiblePos = Edible.remove();
        if (world.world.get(possiblePos) != null && world.world.get(possiblePos).isEdibleBy(creature)) {
            return previousPosition;
        } else {
            Position up = new Position(possiblePos.x, possiblePos.y - 1);
            Position down = new Position(possiblePos.x, possiblePos.y + 1);
            Position left = new Position(possiblePos.x - 1, possiblePos.y);
            Position right = new Position(possiblePos.x + 1, possiblePos.y);
            if (world.isGoingAbroad(up) && !searched.contains(up)) {
                Edible.add(up);
                searched.add(up);
                previousPosition.put(up, possiblePos);
            }
            if (world.isGoingAbroad(down) && !searched.contains(down)) {
                Edible.add(down);
                searched.add(down);
                previousPosition.put(down, possiblePos);
            }
            if (world.isGoingAbroad(left) && !searched.contains(left)) {
                Edible.add(left);
                searched.add(left);
                previousPosition.put(left, possiblePos);
            }
            if (world.isGoingAbroad(right) && !searched.contains(right)) {
                Edible.add(right);
                searched.add(right);
                previousPosition.put(right, possiblePos);
            }
        }
    }
    return null;
}
    Position foodPosition(World world, Position start, Creature creature) {
        Queue<Position> Edible = new LinkedList<>();
        Set<Position> searched = new HashSet<>();
        Edible.add(start);
        searched.add(start);
        while (!Edible.isEmpty()) {
            Position possiblePos = Edible.remove();
            if (world.world.get(possiblePos) != null && world.world.get(possiblePos).isEdibleBy(creature)) {
                return possiblePos;
            } else {
                Position up = new Position(possiblePos.x, possiblePos.y - 1);
                Position down = new Position(possiblePos.x, possiblePos.y + 1);
                Position left = new Position(possiblePos.x - 1, possiblePos.y);
                Position right = new Position(possiblePos.x + 1, possiblePos.y);
                if (world.isGoingAbroad(up) && !searched.contains(up)) {
                    Edible.add(up);
                    searched.add(up);
                }
                if (world.isGoingAbroad(down) && !searched.contains(down)) {
                    Edible.add(down);
                    searched.add(down);
                }
                if (world.isGoingAbroad(left) && !searched.contains(left)) {
                    Edible.add(left);
                    searched.add(left);
                }
                if (world.isGoingAbroad(right) && !searched.contains(right)) {
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

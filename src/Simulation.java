import java.util.ArrayList;
import java.util.List;
public class Simulation {
    void decisionPhase(World world, List<Command> commands) {
        for (Entity entity : new ArrayList<>(world.world.values())) {
            if (entity instanceof Predator predator) {
                commands.add(new AttackCommand(predator));
            }
            if (entity instanceof Creature creature) {
                commands.add(new MoveCommand(creature));
            }
        }
    }
    void attackPhase(World world, List<Command> commands) {
        for(Command command : commands) {
            if (command instanceof AttackCommand) {
                command.execute(world);
            }
        }
    }
    void movementPhase(World world, List<Command> commands) {
        for(Command command : commands) {
            if (command instanceof MoveCommand) {
                command.execute(world);
            }
        }
    }
    void deathPhase(World world) {
        for (Entity entity : new ArrayList<>(world.world.values())) {
            if (entity instanceof Creature creature && creature.health <= 0) {
                world.world.put(creature.position, new Meat(creature.position));
            }
        }
    }
    void tick(World world) {
        List<Command> commands = new ArrayList<>();
        decisionPhase(world, commands);
        attackPhase(world, commands);
        movementPhase(world, commands);
        deathPhase(world);
    }
}

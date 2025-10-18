import java.util.ArrayList;
import java.util.List;
public class Simulation {
    void decisionPhase(World world, List<Command> commands) {
        for (Entity entity : new ArrayList<>(world.world.values())) {
            if (entity instanceof Creature creature) {
                commands.add(new MoveCommand(creature));
            }
        }
    }
    void movementPhase(World world, List<Command> commands) {
        for(Command command : commands) {
            command.execute(world);
        }
    }
    void tick(World world) {
        List<Command> commands = new ArrayList<>();
        decisionPhase(world, commands);
        movementPhase(world, commands);
    }
}

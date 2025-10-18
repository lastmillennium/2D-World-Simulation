public class MoveCommand implements Command {
    Creature creature;
    MoveCommand(Creature creature) {
        this.creature = creature;
    }
    public void execute(World world) {
        creature.makeMove(world);
    }
}

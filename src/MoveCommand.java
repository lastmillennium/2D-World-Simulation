public class MoveCommand implements Command {
    Creature creature;
    MoveCommand(Creature creature) {
        this.creature = creature;
    }
    public void execute(World world, Actions actions) {
        creature.makeMove(world, actions);
    }
}

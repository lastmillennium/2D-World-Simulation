public class AttackCommand implements Command {
    Creature creature;
    AttackCommand(Creature creature) {
        this.creature = creature;
    }
    @Override
    public void execute(World world) {
        creature.attack(world);
    }
}

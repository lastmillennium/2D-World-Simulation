import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WorldRenderer renderer = new WorldRenderer();
        Simulation simulation = new Simulation();
        World world1 = new World();
        world1.setupDefaultEntitiesPosition();
        for(int i = 0; i < 30; i++) {
            renderer.render(world1);
            simulation.tick(world1);
            for (Map.Entry<Position, Entity> entry : world1.world.entrySet()) {
                Entity entity = entry.getValue();
                if (entity instanceof Creature creature)
                    System.out.println(creature.health);
            }
            Thread.sleep(1000);
            System.out.print("\033[H\033[J");
        }
    }
}

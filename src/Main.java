public class Main {
    public static void main(String[] args) throws InterruptedException {
        WorldRenderer renderer = new WorldRenderer();
        Simulation simulation = new Simulation();
        World world1 = new World();
        world1.setupDefaultEntitiesPosition();
        for(int i = 0; i < 17; i++) {
            renderer.render(world1);
            simulation.tick(world1);
            Thread.sleep(600);
            System.out.print("\033[H\033[J");
        }
    }
}

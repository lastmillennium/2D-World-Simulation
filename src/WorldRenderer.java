public class WorldRenderer {
    void render(World world) {
        for (int y = 0; y < world.depth; y++) {
            for (int x = 0; x < world.width; x++) {
                Entity entity = world.world.get(new Position(x, y));
                if (entity == null) {
                    System.out.print(".");
                } else {
                    System.out.print(entity);
                }
            }
            System.out.println();
        }
    }
}

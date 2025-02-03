package entity;

public class Island {
    private final int width;
    private final int height;
    private Location[][] map;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Location[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                map[x][y] = new Location(x, y);
            }
        }
    }

    public Location getLocation(int x, int y) {
        return map[x][y];
    }

    public Location[][] getMap() {
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
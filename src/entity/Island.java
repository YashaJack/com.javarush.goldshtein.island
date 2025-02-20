package entity;

import java.util.ArrayList;
import java.util.List;

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

    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations.add(map[x][y]);
            }
        }
        return locations;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

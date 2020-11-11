package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    // ATTENTION!!! The origin of the coordinate system is in the left down side.
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    private static final TETile[][] teTile = new TETile[WIDTH][HEIGHT];

    public void addHexagon(int sideLength, int xPos, int yPos) {
        TERenderer renderer = new TERenderer();
        renderer.initialize(WIDTH, HEIGHT);
        // initialize the tiles
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                teTile[x][y] = Tileset.NOTHING;
            }
        }
        // set the tiles and draw
        setAll(sideLength, xPos, yPos);
        renderer.renderFrame(teTile);
    }

    // set every line in the hexagon
    private void setAll(int sideLength, int xPos, int yPos) {
        for (int i = 1; i <= 2 * sideLength; i += 1) {
            setLine(calcX(sideLength, xPos, i), calcY(sideLength, yPos, i),
                    calcNum(sideLength, i));
        }
    }

    // calculate the x coordinate of the ith line
    private int calcX(int sideLength, int xPos, int ith) {
        // the half above
        if (ith <= sideLength) {
            return xPos + sideLength - ith;
        } else { // the half below
            return xPos + (ith - 1 - sideLength);
        }
    }
    // calculate the y coordinate of the ith line
    private int calcY(int sideLength, int yPos, int ith) {
        return yPos + 2 * sideLength - ith;
    }
    // calculate the number of tiles in the ith line
    private int calcNum(int sideLength, int ith) {
        // the half above
        if (ith <= sideLength) {
            return sideLength + (ith - 1) * 2;
        } else { // the half below
            return sideLength + (2 * sideLength - ith) * 2;
        }
    }

    // set the line specified by coordinates and tile numbers
    private void setLine(int x, int y, int num) {
        for (int i = x; i < x + num; i += 1) {
            teTile[i][y] = Tileset.WALL;
        }
    }

    public static void main(String[] args) {
        HexWorld hexWorld = new HexWorld();
        hexWorld.addHexagon(3, 3, 4);
        System.out.println();
    }
}

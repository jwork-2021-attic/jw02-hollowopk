package homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {

    public static void main(String[] args) throws IOException {
        int size = 64;
        Line line = new Line(size);
        int[] randomArray = getRandomArray(size);
        for (int i = 0;i < size;i++) {
            int r = (Colors.colors[i] >> 16) & 0xff;
            int g = (Colors.colors[i] >> 8) & 0xff;
            int b = Colors.colors[i] & 0xff;
            line.put(new Monster(r,g,b,randomArray[i]), i);
        }

        Snake theSnake = Snake.getTheSnake();

        Sorter bubbleSorter = new BubbleSorter();
        Sorter quickSorter = new QuickSorter();

        theSnake.setSorter(quickSorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

    public static int[] getRandomArray(int size) {
        int[] origin;
        int[] res;
        origin = new int[size];
        res = new int[size];
        for (int i = 0;i < size;i++) {
            origin[i] = i;
        }
        Random r = new Random();
        for (int j = 0;j < size;j++) {
            int index = r.nextInt(size-j);
            res[j] = origin[index];
            origin[index] = origin[size-1-j];
        }
        return res;
    }

}

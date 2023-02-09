import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BubbleSort {
    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < array.length; i++) {
                writer.write(String.valueOf(array[i]) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static int[] readFileToArray(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            int[] array = new int[0];
            while (line != null) {
                int[] temp = new int[array.length + 1];
                for (int i = 0; i < array.length; i++) {
                    temp[i] = array[i];
                }
                temp[temp.length - 1] = Integer.parseInt(line);
                array = temp;
                line = reader.readLine();
            }
            reader.close();
            return array;
        } catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = createRandomArray(10);
        writeArrayToFile(array, "array.txt");
        int[] sortedArray = readFileToArray("array.txt");
        bubbleSort(sortedArray);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }
}

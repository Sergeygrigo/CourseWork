import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);

        System.out.println("\tВВОД ПАРАМЕТРОВ РЮКЗАКА");

        System.out.print("Введите грузоподъемность >>> ");
        int weight = in.nextInt();

        System.out.print("Введите вместимость >>> ");
        int capacity = in.nextInt();

        System.out.println();

        Backpack backpack = new Backpack(weight, capacity);

        GoldBars goldBars[];
        goldBars = new GoldBars[1000];

        Random random = new Random();

        for (int i = 0; i<1000; i++){
            goldBars[i] = new GoldBars(i,random.nextInt(9) + 1, random.nextInt(1000000) + 1, random.nextInt(99) + 1);
        }


        //вызов алгоритма динамического перебора
        double dynamicSelectionDuration = KnapsackAlgorithms.dynamicSelection(backpack,goldBars);

        //вызов жадного алгоритма
        double greedySelectionDuration = KnapsackAlgorithms.greedySelection(backpack,goldBars);

        System.out.println();

        System.out.println("Время выполнения алгоритма динамического перебора " + dynamicSelectionDuration + " ms");

        System.out.println("Время выполнения жадного алгоритма " + greedySelectionDuration + " ms");
    }
}

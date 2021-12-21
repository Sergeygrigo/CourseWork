import java.util.*;
import java.util.List;
import java.math.*;

public class KnapsackAlgorithms {
    static double dynamicSelection(Backpack backpack, GoldBars[] goldBars)
    {

        long startTime = System.currentTimeMillis();# Jetbrains IDE Crack

0.  {Product} - продукт (clion, idea, и тд)
    {InstallDir} - путь до установленного продукта (CLion, IDEA, и тд) 

1. Копируем JetbrainsCrack.jar to ${InstallDir}/bin

2. Редактируем файл "${Product}.vmoptions" (либо "${Product}${64}.vmoptions") в папке {InstallDir}/bin:
    
    2.1  Добавляем в конце файла (с новой строки): 

        -javaagent:{InstallDir}/bin/JetbrainsCrack.jar

3. Запускаем продукт.

4. Вводим в поле ключа любое значение.

5. Готово.

        int n = goldBars.length;
        int W = backpack.getWeight();
        int V = backpack.getCapacity();

        Vector<Integer> wt = new Vector<Integer>(n);
        Vector<Integer> sz = new Vector<Integer>(n);
        Vector<Integer> val = new Vector<Integer>(n);

        for (int i = 0; i < n; i++)
            wt.add(goldBars[i].getWeight());

        for (int i = 0; i < n; i++)
            sz.add(goldBars[i].getSize());

        for (int i = 0; i < n; i++)
            val.add(goldBars[i].getPrice());


        int i, w, v;
        int K[][][] = new int[n+1][W+1][V+1];



        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                for (v = 0; v<=V; v++)
                {
                    if (i==0 || w==0 || v==0)
                        K[i][w][v] = 0;
                    else if (wt.elementAt(i-1) <= w && sz.elementAt(i-1) <= v) {
                        K[i][w][v] = max(val.elementAt(i - 1) + K[i - 1][w - wt.elementAt(i - 1)][v - sz.elementAt(i - 1)], K[i - 1][w][v]);
                    }
                    else
                        K[i][w][v] = K[i-1][w][v];
                }
            }
        }

        List<GoldBars> ans = findAns(K, goldBars, n,W, V);

        long stopTime = System.currentTimeMillis();

        System.out.println(K[n][W][V]);
        for (GoldBars goldBar: ans)
            System.out.println("- " + goldBar.str());


        return stopTime - startTime;

    }

    static List<GoldBars> findAns(int[][][] A, GoldBars[] goldBars, int n, int W, int V) {
        int res = A[n][W][V];
        int w = W;
        int v = V;
        List<GoldBars> itemsSolution = new ArrayList<>();

        for (int i = n; i > 0  &&  res > 0; i--) {
            if (res != A[i-1][w][v]) {
                itemsSolution.add(goldBars[i-1]);

                res -= goldBars[i-1].getPrice();
                w = w - goldBars[i-1].getWeight();
                v = v - goldBars[i-1].getSize();
            }
        }

        return itemsSolution;
    }


    static double greedySelection(Backpack backpack, GoldBars[] goldBars) {

        long startTime = System.currentTimeMillis();

        int n = goldBars.length;
        int W = backpack.getWeight();
        int V = backpack.getCapacity();
        int w_pack = 0;
        int v_pack = 0;
        int price = 0;


        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (goldBars[j].getPrice() < goldBars[j + 1].getPrice()) {
                    goldBars[j] = returnFirst(goldBars[j + 1], goldBars[j + 1] = goldBars[j]);
                }
        }

        List<GoldBars> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (goldBars[i].getWeight() + w_pack <= W && goldBars[i].getSize() + v_pack <= V) {
                ans.add(goldBars[i]);
                price += goldBars[i].getPrice();
                v_pack = v_pack + goldBars[i].getSize();
                w_pack = w_pack + goldBars[i].getWeight();
            }
        }

        long stopTime = System.currentTimeMillis();

        System.out.println(price);
        for (GoldBars goldBar: ans)
            System.out.println("- " + goldBar.str());


        return stopTime - startTime;

    }



    static <T> T returnFirst(T a,T b) {
        return a;
    }

    static int max(int a, int b) { return (a > b)? a : b; }

    ////////////////
}

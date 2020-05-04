package Puzzle.util;

import java.util.ArrayList;
import java.util.Random;

public class Rand {
    private static Random random = new Random();

    public static int getRandomNumber(int n){
        return random.nextInt(n);
    }

    public static ArrayList<Integer> getRandomArray(int cnt, int n, int base){
        ArrayList<Integer> init = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++)
            init.add(i);
        for(int i = cnt - 1; i >= 0; i--){
            int ind = getRandomNumber(i + 1);
            ans.add(init.get(ind));
            init.remove(ind);
        }

        return ans;
    }
}

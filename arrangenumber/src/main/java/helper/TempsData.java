package helper;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import model.MGame;
import model.MMain;

/**
 * Created by tan.nt on 11/9/17.
 */

public class TempsData {

    public static int [] generateNoDuplicateNumber( int size) {
        int [] a = new int[size];
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        while (list.size() <= size){
            int i = random.nextInt(AppConstant.MAX_RANGE) + 1;
            if (!list.contains(i)){
                list.add(i);
            }
        }
        for (int i = 0; i < size; i ++){
            a[i] = list.get(i);
        }
        return a;
    }

    public static MGame generateGame(int maxNoZero, int lengthArr) {
        int [] a = generateNoDuplicateNumber(maxNoZero);
        int [] result = new int[lengthArr];
        for(int i = 0; i < a.length; i ++){
            result[i] = a[i];
        }
        for (int i = a.length; i <lengthArr; i ++){
            result[i] = 0;
        }
        MGame mGame = new MGame();
        mGame.setResults(convertIntegerArrayToResult(a));
        mGame.setAllResults(convertIntegerArrayToResult(shuffleArray(result)));
        return mGame;
    }

    private static int[] shuffleArray(int [] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }

    private static List<MMain> convertIntegerArrayToResult(int [] a){
        List<MMain> list = new ArrayList<>();
        for (int i = 0, length = a.length;  i <length; i ++){
            MMain mMain = new MMain();
            mMain.setValue(a[i]);
            list.add(mMain);
        }
        return list;
    }

    public static List<MMain> arrangementWithType(AppConstant.TYPE_ARRANGEMENT typeArrangement, List<MMain> input){
        if (typeArrangement == AppConstant.TYPE_ARRANGEMENT.INCREASE){
            Collections.sort(input, new Comparator<MMain>() {
                @Override
                public int compare(MMain mMain, MMain t1) {
                    return mMain.getValue() - t1.getValue();
                }
            });
        } else if (typeArrangement == AppConstant.TYPE_ARRANGEMENT.DECREASE){
            Collections.sort(input, new Comparator<MMain>() {
                @Override
                public int compare(MMain mMain, MMain t1) {
                    return t1.getValue() - mMain.getValue();
                }
            });
        }
        return input;
    }
}


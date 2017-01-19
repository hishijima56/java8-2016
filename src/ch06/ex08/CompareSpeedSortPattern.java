/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch06.ex08;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 練習問題06_08
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/19
 */
public class CompareSpeedSortPattern {

    /**
     * mainメソッドです。
     * @param args 実行時引数
     */
    public static void main(String[] args) {

        int sample1 = 100000;
        int sample2 = 1000000;
        int sample3 = 5000000;
        int sample4 = 10000000;

        //100個
        int[] arraySample1 = new int[sample1];
        int[] parallelArraySample1 = new int[sample1];

        IntStream.range(1, sample1).forEach(i -> arraySample1[sample1-i] = i);
        IntStream.range(1, sample1).forEach(i -> parallelArraySample1[sample1-i] = i);

        System.out.println(sample1 + "個");
        new CompareSpeedSortPattern().benchMark(parallelArraySample1, arraySample1);

        //1000個
        int[] arraySample2 = new int[sample2];
        int[] parallelArraySample2 = new int[sample2];

        IntStream.range(1, sample2).forEach(i -> arraySample2[sample2-i] = i);
        IntStream.range(1, sample2).forEach(i -> parallelArraySample2[sample2-i] = i);

        System.out.println(sample2 + "個");
        new CompareSpeedSortPattern().benchMark(parallelArraySample2, arraySample2);

        //10000個
        int[] arraySample3 = new int[sample3];
        int[] parallelArraySample3 = new int[sample3];

        IntStream.range(1, sample3).forEach(i -> arraySample3[sample3-i] = i);
        IntStream.range(1, sample3).forEach(i -> parallelArraySample3[sample3-i] = i);

        System.out.println(sample3 + "個");
        new CompareSpeedSortPattern().benchMark(parallelArraySample3, arraySample3);

        //100000個
        int[] arraySample4 = new int[sample4];
        int[] parallelArraySample4 = new int[sample4];

        IntStream.range(1, sample4).forEach(i -> arraySample4[sample4-i] = i);
        IntStream.range(1, sample4).forEach(i -> parallelArraySample4[sample4-i] = i);

        System.out.println(sample4 + "個");
        new CompareSpeedSortPattern().benchMark(parallelArraySample4, arraySample4);


    }



    private void benchMark(int[] parallelArray, int[] array){
        long parallelStartTime;
        long parallelEndTime;
        long startTime;
        long endTime;

        //parallel
        parallelStartTime = System.nanoTime();
        Arrays.parallelSort(parallelArray);
        parallelEndTime = System.nanoTime();

        startTime = System.nanoTime();
        Arrays.sort(array);
        endTime = System.nanoTime();

        System.out.println("Arrays.parallelSort Time : " + (parallelEndTime - parallelStartTime));
        System.out.println("Arrays.sort         Time : " + (endTime - startTime));

    }
}

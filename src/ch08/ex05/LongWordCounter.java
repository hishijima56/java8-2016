/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 練習問題08_05
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/14
 */
public class LongWordCounter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            String contents = new String(Files.readAllBytes(Paths.get(".\\src\\ch02\\ex01\\alice.txt")), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
            List<String> words2 = Arrays.asList(contents.split("[\\P{L}]+"));

            long startTime;
            long endTime;
            long count;

            startTime = System.nanoTime();
            count = words.stream().filter(word -> word.length() > 12).count();
            endTime = System.nanoTime();

            System.out.println("---use stream---");
            System.out.println("count : " + count);
            System.out.println("time : " + (endTime - startTime));
            System.out.println("---end use stream---");

            long[] count2 = new long[1];
            startTime = System.nanoTime();
            words2.forEach(word -> {
                if (word.length() > 12)
                    count2[0]++;
            });
            endTime = System.nanoTime();

            System.out.println("---use forEach---");
            System.out.println("count : " + count2[0]);
            System.out.println("time : " + (endTime - startTime));
            System.out.println("---end use forEach---");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch06.ex06;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 連取問題06_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/19
 */
public class FileTextMapEx {

    private static final int THREADS_SIZE = 2;

    private static final int TIMEOUT_MINUTES = 10;

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Set<File>> fileTextMap = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);

        File aliceFile = new File(".\\src\\ch06\\ex05\\alice.txt");
        File poohFile = new File(".\\src\\ch06\\ex05\\winniethepooh.txt");

        executor.submit(() -> {
            String aliceContents;
            try {
                aliceContents = new String(Files.readAllBytes(Paths.get(".\\src\\ch06\\ex05\\alice.txt")), StandardCharsets.UTF_8);
                Arrays.asList(aliceContents.split("[\\P{L}]+")).parallelStream().forEach(s -> {
                    Set<File> aliceSet = new HashSet<>();
                    aliceSet.add(aliceFile);
                    fileTextMap.computeIfAbsent(s, key -> aliceSet).addAll(aliceSet);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> {
            String poohContents;
            try {
                poohContents = new String(Files.readAllBytes(Paths.get(".\\src\\ch06\\ex05\\winniethepooh.txt")), StandardCharsets.UTF_8);
                Arrays.asList(poohContents.split("[\\P{L}]+")).parallelStream().forEach(s -> {
                    Set<File> poohSet = new HashSet<>();
                    poohSet.add(poohFile);
                    fileTextMap.computeIfAbsent(s, key -> poohSet).addAll(poohSet);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();
        executor.awaitTermination(TIMEOUT_MINUTES, TimeUnit.MINUTES);

        fileTextMap.keySet().stream().limit(1000).forEach(k -> System.out.println(k + " : " + fileTextMap.get(k).toString()));
    }

}

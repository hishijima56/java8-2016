/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
package ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 練習問題02_02
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/15
 */
public class StringsFilter {

    private static final int LENGTH_FILTER = 8;

    /**
     * 指定した文字数以上である文字列のリスト(先頭5個まで)を返します。
     *
     * @param strs 文字列リスト
     * @param length 指定文字数
     * @return 条件に合致する文字列リスト(先頭5個まで)
     */
    public static List<String> lengthFilter(List<String> strs, int length) {
        return strs.stream().filter(s -> {
            System.out.println(s);
            return s.length() >= length;
        }).limit(5).collect(Collectors.toList());
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String contents;
        try {
            contents = new String(Files.readAllBytes(Paths.get(".\\src\\ch02\\ex01\\alice.txt")), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
            System.out.println("*********lengthFilter start*********");

            List<String> filteredWords = lengthFilter(words, LENGTH_FILTER);
            System.out.println("*********lengthFilter end*********");

            filteredWords.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

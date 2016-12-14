/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
package ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 練習問題02_01
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/15
 */
public class ForLoopParallel {

    /**
     * 指定文字列長
     */
    private static final int LENGTH_WORD = 12;

    /**
     * 1セグメント数
     */
    private static final int LIST_SEGMENT = 10;

    /**
     * 集計カウント
     */
    private static int count = 0;

    /**
     * 並列スレッド
     */
    private static List<WordCountThread> threads;

    /**
     * 指定されたワードリストのうち、指定文字列長を超えている文字列数を返します。
     * @param words ワードリスト
     * @return 指定文字列長を超えているワード数
     */
    public static int countLongWords(List<String> words) {
        threads = new ArrayList<>();
        count = 0;

        //wordsをセグメントごとに分割します。
        for (int i = 0; i < words.size(); i += LIST_SEGMENT) {
            threads.add(new WordCountThread(words.subList(i, i + LIST_SEGMENT <= words.size() ? i + LIST_SEGMENT : words.size() - 1)));
        }

        //スレッドを開始します。
        threads.forEach(WordCountThread::start);

        for (WordCountThread wct : threads) {
            try {
                //終了後にcountを集計します。
                wct.join();
                count += wct.count;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //集計を返します。
        return count;
    }

    /**
     * mainメソッド
     * @param args 実行時引数
     */
    public static void main(String[] args) {
        String contents;
        try {
            System.out.println();
            contents = new String(Files.readAllBytes(Paths.get(".\\src\\ch02\\ex01\\alice.txt")), StandardCharsets.UTF_8);
            List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
            int wordCount = countLongWords(words);
            System.out.println(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * セグメントごとに指定文字数を超えた単語数をカウントするスレッドクラスです。
     *
     * @author Hidetoshi Ishijima
     *
     * @version $Revision: $ $Date: $
     * @since 2016/11/15
     */
    private static class WordCountThread extends Thread {

        /**
         * セグメントごとのカウント
         */
        private int count = 0;

        /**
         * セグメントごとの文字列リスト
         */
        private List<String> words;

        /**
         * コンストラクタ
         * @param words
         */
        public WordCountThread(List<String> words) {
            this.words = words;
        }

        @Override
        public void run() {
            for (String word : words) {
                System.out.println(word);
                if (word.length() > LENGTH_WORD)
                    count++;
            }
        }

    }

}

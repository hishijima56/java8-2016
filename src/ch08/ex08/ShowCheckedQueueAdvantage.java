/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex08;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

/**
 * 練習問題08_08
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/15
 */
public class ShowCheckedQueueAdvantage {

    /**
     * mainメソッド
     * @param args 実行時引数
     */
    public static void main(String[] args) {

        Queue<Path> queue = new ArrayDeque<>();
        Queue<Path> queue2 = Collections.checkedQueue(queue, Path.class);
        try {
            getMoreWork(queue2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getMoreWork(Queue q) {
        q.offer(Paths.get("alice.txt"));
        q.offer("alice.txt"); // 型が異なる
    }

}

/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
/*
 * Copyrightℂ RICOH JAPAN Corporation.
 * All Rights Reserved.
*/
package ch01.ex01;

import java.util.Arrays;

/**
 * 練習問題01_01
 *
 * @author リコージャパン株式会社 石嶋 秀敏
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/13
 */
public class SortThreadCheck {

    /**
     * mainスレッドです
     * @param args 実行時引数
     */
    public static void main(String[] args) {

        System.out.println("current thread : " + Thread.currentThread().toString());

        Thread currentThread = Thread.currentThread();

        String[] strs = {"abc","def","ghi","jkl","mno","pqr","stu"};

        Arrays.sort(strs, (a,b) -> {
            //コンパレータ内で呼び出したスレッドは呼び出し元のスレッドと同一である
            System.out.println("arrays sort current thread : " + Thread.currentThread().toString());
            System.out.println(currentThread == Thread.currentThread());
            return 1;
        });


    }
}

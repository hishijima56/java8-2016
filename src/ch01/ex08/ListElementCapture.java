/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
/*
 * Copyrightℂ RICOH JAPAN Corporation.
 * All Rights Reserved.
*/
package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

/**
 * 練習問題01_08
 * @author リコージャパン株式会社 石嶋 秀敏
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/16
 */
public class ListElementCapture {

    public static void main(String[] args) {
        String[] names = { "Peter", "paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }

        runners.forEach(r -> new Thread(r).start());

        //下記はコンパイルエラー
        //ラムダ式内で使用する外部変数は暗黙的finalである必要があるため
        //        runners.clear();
        //        for(int i=0; i<names.length; i++){
        //            runners.add(() -> System.out.println(names[i]));
        //        }
    }

}

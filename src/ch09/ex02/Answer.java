/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 練習問題09_02
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/07
 */
public class Answer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //        try (Scanner in = new Scanner(Paths.get("words")); PrintWriter out = new PrintWriter("out.txt")) {
        //            while (in.hasNext()) {
        //                out.println(in.next().toLowerCase());
        //            }
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }

        Scanner in = null;
        PrintWriter out = null;
        try {
            // Scanner のコンストラクタ
            in = new Scanner(Paths.get("./src/ch09/ex01/alice.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        try {
            //PrintWriterのコンストラクタ
            out = new PrintWriter("./src/ch09/ex01/out.txt");
        } catch (IOException e) {
            //Scannerのオブジェクトが生成されているためcloseする
            try {
                in.close();
            } catch (Throwable t) {
                e.addSuppressed(t);
            }
            e.printStackTrace();
            throw e;
        }

        try {
            //本処理
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Exception e) {
            try {
                //Scannerのclose
                in.close();
            } catch (Throwable t) {
                e.addSuppressed(t);
            }
            try {
                //PrintWriterのclose
                out.close();
            } catch (Throwable t) {
                e.addSuppressed(t);
            }
            e.printStackTrace();
            throw e;
        }

        try {
            //Scannerのclose
            in.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        try {
            //PrintWriterのclose
            out.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}

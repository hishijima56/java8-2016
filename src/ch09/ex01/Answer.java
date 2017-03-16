/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 練習問題09_01
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
            in = new Scanner(Paths.get("words"));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        try {
            out = new PrintWriter("out.txt");
        } catch (IOException e) {
            e.printStackTrace();
            try {
                in.close();
            } catch (Throwable t) {
                t.printStackTrace();
            }
            throw e;
        }
        try {
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Throwable t) {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

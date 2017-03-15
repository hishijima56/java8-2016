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
     */
    public static void main(String[] args) {

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
            out = new PrintWriter("out.txt");
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}

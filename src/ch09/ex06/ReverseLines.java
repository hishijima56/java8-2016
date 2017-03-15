/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex06;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/**
 * 練習問題09_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/12
 */
public class ReverseLines {

    /**
     * @param args
     */
    public static void main(String[] args) {
         try {
            List<String> contents = Files.readAllLines(Paths.get(".\\src\\ch09\\ex06\\alice.txt"), StandardCharsets.UTF_8);
            Collections.reverse(contents);

            Path outPath = Paths.get(".\\src\\ch09\\ex06\\out.txt");
            if(Files.exists(outPath, LinkOption.NOFOLLOW_LINKS)){
                Files.delete(outPath);
            }
            Files.createFile(outPath);

            Files.write(outPath, contents, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

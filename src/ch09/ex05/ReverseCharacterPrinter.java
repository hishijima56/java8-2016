/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 練習問題09_05
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/07
 */
public class ReverseCharacterPrinter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            byte[] bytes = reverseBytes(Files.readAllBytes(Paths.get(".\\src\\ch09\\ex05\\alice.txt")));

            Path outPath = Paths.get(".\\src\\ch09\\ex05\\out.txt");
            if(Files.exists(outPath, LinkOption.NOFOLLOW_LINKS)){
                Files.delete(outPath);
            }
            Files.createFile(outPath);

            //書き込み
            Files.write(outPath, bytes, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static byte[] reverseBytes(byte[] bytes) {
        byte[] result = new byte[bytes.length];
        for(int i=0;i<bytes.length;i++){
            result[bytes.length- 1 -i] = bytes[i];
        }
        return result;
    }

}

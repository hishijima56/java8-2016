/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 練習問題09_07
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/03/12
 */
public class SaveWebPage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.google.com");
            InputStream openStream = url.openStream();

            Path outPath = Paths.get(".\\src\\ch09\\ex07\\out.txt");
            if (Files.exists(outPath, LinkOption.NOFOLLOW_LINKS)) {
                Files.delete(outPath);
            }

            Files.copy(openStream, outPath);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

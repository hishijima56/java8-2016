/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
package ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * 練習問題01_04
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/16
 */
public class FilesUtil {

    /**
     * ファイルリストをソートします。
     * @param files {@link File}の配列
     * @return ソート済みの {@link File}の配列(ディレクトリが先、パス名昇順)
     */
    public File[] sort(File[] files) {
        Objects.requireNonNull(files);

        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory()) {
                return f2.isFile() ? -1 : f1.getAbsolutePath().compareTo(f2.getAbsolutePath());
            }
            return f2.isDirectory() ? 1 : f1.getAbsolutePath().compareTo(f2.getAbsolutePath());
        });

        return files;
    }
}

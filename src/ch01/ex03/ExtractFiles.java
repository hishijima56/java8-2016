/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
package ch01.ex03;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 練習問題01_03
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/14
 */
public class ExtractFiles {

    /**
     * 指定したディレクトリの指定した拡張子に一致するファイルを全て返します。
     * @param dir 指定ディレクトリ
     * @param extension 拡張子
     * @return　ファイルリスト
     */
    public List<File> getFilenamesByExtensiton(File dir, String extension) {
        if (Objects.isNull(dir) || Objects.isNull(extension)) {
            throw new IllegalArgumentException("引数がnullです。");
        }
        if (extension.isEmpty()) {
            throw new IllegalArgumentException("拡張子が空文字列です。");
        }
        if (!dir.exists()) {
            throw new IllegalArgumentException("指定したフォルダは存在しません。 指定パス：" + dir.getAbsolutePath());
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("フォルダではありません。指定パス：" + dir.getAbsolutePath());
        }

        //指定した拡張子に一致するファイル名を全て返す。
        String[] fileNames = dir.list((f, s) -> {
            System.out.println(f.getAbsolutePath()); //fはファイルが属するディレクトリ
            System.out.println(s); //sはファイル名
            return s.endsWith(extension);
        });

        List<File> files = new ArrayList<>();
        Arrays.stream(fileNames).forEach(s ->files.add(new File(dir.getAbsolutePath()+ System.getProperty("file.separator") + s)));
        return files;

    }

}

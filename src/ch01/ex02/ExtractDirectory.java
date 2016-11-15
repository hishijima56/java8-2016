/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
/*
 * Copyrightℂ RICOH JAPAN Corporation.
 * All Rights Reserved.
*/
package ch01.ex02;

import java.io.File;
import java.util.Objects;

/**
 * 練習問題01_02
 * @author リコージャパン株式会社 石嶋 秀敏
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/14
 */
public class ExtractDirectory {

    /**
     * 指定したディレクトリの全てのサブディレクトリを返します。
     * ラムダ式で記述しています。
     * @param dir
     * @return　サブディレクトリの配列
     */
    public File[] getSubDirsByLambda(File dir) {
        if (Objects.isNull(dir)) {
            throw new IllegalArgumentException("引数がnullです。");
        }
        if (!dir.exists()) {
            throw new IllegalArgumentException("指定したフォルダは存在しません。 指定パス：" + dir.getAbsolutePath());
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("フォルダではありません。指定パス：" + dir.getAbsolutePath());
        }

        //サブディレクトリを全て返す。
        return dir.listFiles(d -> d.isDirectory());
    }

    /**
     * 指定したディレクトリの全てのサブディレクトリを返します。
     * メソッド参照で記述しています。
     * @param dir
     * @return　サブディレクトリの配列
     */
    public File[] getSubDirsByMethod(File dir) {
        if (Objects.isNull(dir)) {
            throw new IllegalArgumentException("引数がnullです。");
        }

        if (!dir.exists()) {
            throw new IllegalArgumentException("指定したフォルダは存在しません。 指定パス：" + dir.getAbsolutePath());
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("フォルダではありません。指定パス：" + dir.getAbsolutePath());
        }

        //サブディレクトリを全て返す。
        return dir.listFiles(File::isDirectory);
    }

}

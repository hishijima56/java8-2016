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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題01_02
 * @author リコージャパン株式会社 石嶋 秀敏
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/15
 */
public class ExtractDirectoryTest {

    /**
     * テストファイルパス(Windows用)
     */
    private static final String PATH_TARGET_DIRECTORY_WINDOWS = "C:\\";

    /**
     * テストフォルダパス(Linux用)
     */
    private static final String PATH_TARGET_DIRECTORY_LINUX = "/root/";

    private static final String TEST_DIR_NAME = "java8dirTest";

    /**
     * Windows判定用
     */
    private static final boolean ISWINDOWS = "\\".equals(System.getProperty("file.separator"));

    /**
     * ベースディレクトリ
     */
    private File baseDir;

    /**
     * 単体テスト用ディレクトリ作製
     */
    private File testDir;

    private File[] expected = new File[3];

    private File testFile;

    /**
     * test target
     */
    private ExtractDirectory extractDirectory;

    @Before
    public void setUpClass() {
        String testDirPath = (ISWINDOWS ? PATH_TARGET_DIRECTORY_WINDOWS : PATH_TARGET_DIRECTORY_LINUX) + TEST_DIR_NAME;
        testDir = new File(testDirPath);

        testDir.mkdir();
        expected[0] = new File(testDirPath + System.getProperty("file.separator") + "test01");
        expected[1] = new File(testDirPath + System.getProperty("file.separator") + "test02");
        expected[2] = new File(testDirPath + System.getProperty("file.separator") + "test03");

        Arrays.stream(expected).forEach(File::mkdir);

        testFile = new File(testDirPath + System.getProperty("file.separator") +"test.java");
        try {
            testFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        extractDirectory = new ExtractDirectory();
    }


    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByLambda(java.io.File)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSubDirsByLambdaNull() {
        extractDirectory.getSubDirsByLambda(null);
    }

    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByLambda(java.io.File)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSubDirsByLambdaNotExist() {
        extractDirectory.getSubDirsByLambda(new File(".\\test.java"));
    }

    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByLambda(java.io.File)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSubDirsByLambdaNotDir() {
        extractDirectory.getSubDirsByLambda(testFile);
    }

    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByLambda(java.io.File)} のためのテスト・メソッド。
     */
    @Test
    public void testGetSubDirsByLambda() {
        File[] actual = extractDirectory.getSubDirsByLambda(testDir);
        assertThat(actual, is(expected));
    }

    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByLambda(java.io.File)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSubDirsByMethodNull() {
        extractDirectory.getSubDirsByMethod(null);
    }

    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByLambda(java.io.File)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSubDirsByMethodNotExist() {
        extractDirectory.getSubDirsByMethod(new File(".\\test.java"));
    }

    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByLambda(java.io.File)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetSubDirsByMethodNotDir() {
        extractDirectory.getSubDirsByMethod(testFile);
    }

    /**
     * {@link ch01.ex02.ExtractDirectory#getSubDirsByMethod(java.io.File)} のためのテスト・メソッド。
     */
    @Test
    public void testGetSubDirsByMethod() {
        File[] actual = extractDirectory.getSubDirsByMethod(testDir);
        assertThat(actual, is(expected));

    }
}

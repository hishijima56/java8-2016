/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
/*
 * Copyrightℂ RICOH JAPAN Corporation.
 * All Rights Reserved.
*/
package ch01.ex03;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題01_03
 * @author リコージャパン株式会社 石嶋 秀敏
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/15
 */
public class ExtractFilesTest {

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
     * 単体テスト用ディレクトリ作製
     */
    private static File testDir;

    private File[] expected = new File[5];

    private File testFile;

    private String extension = "csv";

    /**
     * test target
     */
    private ExtractFiles extractFiles;

    @Before
    public void setUpClass() {
        String testDirPath = (ISWINDOWS ? PATH_TARGET_DIRECTORY_WINDOWS : PATH_TARGET_DIRECTORY_LINUX) + TEST_DIR_NAME;
        testDir = new File(testDirPath);

        testDir.mkdir();
        expected[0] = new File(testDirPath + System.getProperty("file.separator") + "test01.txt");
        expected[1] = new File(testDirPath + System.getProperty("file.separator") + "test02.csv");
        expected[2] = new File(testDirPath + System.getProperty("file.separator") + "test03.txt");
        expected[3] = new File(testDirPath + System.getProperty("file.separator") + "test04.txt");
        expected[4] = new File(testDirPath + System.getProperty("file.separator") + "test05.csv");

        try {
            Arrays.stream(expected).forEach(t -> {
                try {
                    t.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            testFile = new File(testDirPath + System.getProperty("file.separator") + "test.java");
            testFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        extractFiles = new ExtractFiles();
    }

    @AfterClass
    public static void tearDownAfterClass(){
        //テスト時に作製したフォルダ・ファイルを削除します。
        Arrays.stream(testDir.listFiles()).forEach(File::delete);
        testDir.delete();
    }

    /**
     * {@link ch01.ex03.ExtractFiles#getFilenamesByExtensiton(File, String)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFilenamesByExtensitonDirNull() {
        extractFiles.getFilenamesByExtensiton(null, extension);
    }

    /**
     * {@link ch01.ex03.ExtractFiles#getFilenamesByExtensiton(File, String)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFilenamesByExtensitonDirNotExist() {
        extractFiles.getFilenamesByExtensiton(new File(".\\test.java"), extension);
    }

    /**
     * {@link ch01.ex03.ExtractFiles#getFilenamesByExtensiton(File, String)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFilenamesByExtensitonNotDir() {
        extractFiles.getFilenamesByExtensiton(testFile, extension);
    }

    /**
     * {@link ch01.ex03.ExtractFiles#getFilenamesByExtensiton(File, String)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFilenamesByExtensitonExtNull() {
        extractFiles.getFilenamesByExtensiton(testFile, null);
    }

    /**
     * {@link ch01.ex03.ExtractFiles#getFilenamesByExtensiton(File, String)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFilenamesByExtensitonExtEmpty() {
        extractFiles.getFilenamesByExtensiton(testFile, "");
    }

    /**
     * {@link ch01.ex03.ExtractFiles#getFilenamesByExtensiton(File, String)}のためのテスト・メソッド。
     */
    @Test
    public void testGetFilenamesByExtensiton() {
        List<File> files = extractFiles.getFilenamesByExtensiton(testDir, extension);
        assertThat(files.size(), is(2));
        assertThat(files.get(0).getAbsolutePath(), is(expected[1].getAbsolutePath()));
        assertThat(files.get(1).getAbsolutePath(), is(expected[4].getAbsolutePath()));
    }
}

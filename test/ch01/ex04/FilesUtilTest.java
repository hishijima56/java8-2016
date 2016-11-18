/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/
/*
 * Copyrightℂ RICOH JAPAN Corporation.
 * All Rights Reserved.
*/
package ch01.ex04;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 練習問題01_04
 * @author リコージャパン株式会社 石嶋 秀敏
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/16
 */
public class FilesUtilTest {

    /**
     * テストファイルパス(Windows用)
     */
    private static final String PATH_TARGET_DIRECTORY_WINDOWS = "C:\\";

    /**
     * テストフォルダパス(Linux・UNIX用)
     */
    private static final String PATH_TARGET_DIRECTORY_LINUX = "/tmp/";

    private static final String TEST_DIR_NAME = "java8dirTest";

    /**
     * Windows判定用
     */
    private static final boolean ISWINDOWS = "\\".equals(System.getProperty("file.separator"));

    /**
     * 単体テスト用ディレクトリ作製
     */
    private static File testDir;

    private static File[] testFiles = new File[5];

    private static File[] expected = new File[7];


    private static File testFile;

    /**
     * test target
     */
    private static FilesUtil target;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        target = new FilesUtil();

        String testDirPath = (ISWINDOWS ? PATH_TARGET_DIRECTORY_WINDOWS : PATH_TARGET_DIRECTORY_LINUX) + TEST_DIR_NAME;
        testDir = new File(testDirPath);

        testDir.mkdir();
        testFiles[0] = new File(testDirPath + System.getProperty("file.separator") + "test51.txt");
        testFiles[1] = new File(testDirPath + System.getProperty("file.separator") + "test12.csv");
        testFiles[2] = new File(testDirPath + System.getProperty("file.separator") + "test13.txt");
        testFiles[3] = new File(testDirPath + System.getProperty("file.separator") + "test44.txt");
        testFiles[4] = new File(testDirPath + System.getProperty("file.separator") + "test05.csv");

        try {
            Arrays.stream(testFiles).forEach(t -> {
                try {
                    t.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            testFile = new File(testDirPath + System.getProperty("file.separator") + "test.java");
            testFile.createNewFile();


            expected[0] = new File(testDirPath + System.getProperty("file.separator") + "test51.txt");
            expected[1] = new File(testDirPath + System.getProperty("file.separator") + "test12.csv");
            expected[2] = new File(testDirPath + System.getProperty("file.separator") + "test13.txt");
            expected[3] = new File(testDirPath + System.getProperty("file.separator") + "test44.txt");
            expected[4] = new File(testDirPath + System.getProperty("file.separator") + "test05.csv");
            expected[5] = testDir;
            expected[6] = testFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownAfterClass(){
        //テスト時に作製したフォルダ・ファイルを削除します。
        Arrays.stream(testDir.listFiles()).forEach(File::delete);
        testDir.delete();
    }


    /**
     * {@link ch01.ex04.FilesUtil#sort(java.io.File[])} のためのテスト・メソッド。
     */
    @Test
    public void testSort() {
        //TODO テストケースがたりない
        File[] actual = target.sort(expected);
        Arrays.stream(actual).forEach(System.out::println);

    }

}

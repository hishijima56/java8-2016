/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch08.ex09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 練習問題08_09
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/02/15
 */
public class ScannerEx {

    /**
     * {@link Scanner}
     */
    private final Scanner sc;

    public ScannerEx(File source) throws FileNotFoundException {
        this.sc = new Scanner(source);
    }

    public ScannerEx(InputStream source) {
        this.sc = new Scanner(source);
    }

    public ScannerEx(String source) {
        this.sc = new Scanner(source);
    }

    public ScannerEx(Readable source) {
        this.sc = new Scanner(source);
    }

    public ScannerEx(Path source) throws IOException {
        this.sc = new Scanner(source);
    }

    public ScannerEx(ReadableByteChannel source) {
        this.sc = new Scanner(source);
    }

    public ScannerEx(File source, String charsetName) throws FileNotFoundException {
        this.sc = new Scanner(source, charsetName);
    }

    public ScannerEx(InputStream source, String charsetName) {
        this.sc = new Scanner(source, charsetName);
    }

    public ScannerEx(Path source, String charsetName) throws IOException {
        this.sc = new Scanner(source, charsetName);
    }

    public ScannerEx(ReadableByteChannel source, String charsetName) {
        this.sc = new Scanner(source, charsetName);
    }

    /**
     * 行のストリームに変換します。
     * @return Stream<String> 行のストリーム
     */
    public Stream<String> lines() {
        Iterator<String> iter = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return sc.hasNextLine();
            }

            @Override
            public String next() {
                return sc.nextLine();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    /**
     * 単語のストリームに変換します。
     * @return Stream<String> 単語のストリーム
     */
    public Stream<String> words() {
        Iterator<String> iter = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return sc.hasNext();
            }

            @Override
            public String next() {
                return sc.next();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    /**
     * 整数のストリームに変換します。
     * @return Stream<String> 整数のストリーム
     */
    public Stream<Integer> numerics() {
        Iterator<Integer> iter = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                while(sc.hasNext()){
                    if(sc.hasNextInt()){
                        return true;
                    }
                    sc.next();
                }
                return false;
            }

            @Override
            public Integer next() {
                return sc.nextInt();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    /**
     * double値のストリームに変換します。
     * @return Stream<String> double値のストリーム
     */
    public Stream<Double> doubles() {
        Iterator<Double> iter = new Iterator<Double>() {
            @Override
            public boolean hasNext() {
                while(sc.hasNext()){
                    if(sc.hasNextDouble()){
                        return true;
                    }
                    sc.next();
                }
                return false;
            }

            @Override
            public Double next() {
                return sc.nextDouble();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    public void close(){
        this.sc.close();
    }

    public static void main(String[] args) {
        ScannerEx scex;
        try {
            scex = new ScannerEx(Paths.get("./src/ch08/ex09/alice.txt"));

            //行ごとに出力する
            System.out.println("--lines--");
            scex.lines().forEach(System.out::println);
            System.out.println("--end lines--");
            scex.close();

            scex = new ScannerEx(Paths.get("./src/ch08/ex09/alice.txt"));
            //単語ごとに出力する
            System.out.println("--words--");
            scex.words().forEach(System.out::println);
            System.out.println("--end words--");
            scex.close();

            scex = new ScannerEx(Paths.get("./src/ch08/ex09/java8programming.txt"));
            //整数ごとに出力する
            System.out.println("--numerics--");
            scex.numerics().forEach(System.out::println);
            System.out.println("--end numerics--");
            scex.close();

            scex = new ScannerEx(Paths.get("./src/ch08/ex09/alice.txt"));
            //double値ごとに出力する
            System.out.println("--doubles--");
            scex.doubles().forEach(System.out::println);
            System.out.println("--end doubles--");
            scex.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

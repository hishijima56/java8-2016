/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 練習問題02_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public class CharacterStreamMaker {

    /**
     * 指定された文字列を一文字ずつにしたストリームを返します。
     * @param s 指定文字列
     * @return ストリーム
     */
    public static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}

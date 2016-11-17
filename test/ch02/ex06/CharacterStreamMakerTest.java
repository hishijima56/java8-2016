/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch02.ex06;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

/**
 * 練習問題02_06
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/11/17
 */
public class CharacterStreamMakerTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * {@link ch02.ex06.CharacterStreamMaker#characterStream(java.lang.String)} のためのテスト・メソッド。
     */
    @Test
    public void testCharacterStream() {
        String s = "Hello,Java World!";

        Stream<Character> characterStream = CharacterStreamMaker.characterStream(s);

        List<Character> characters = characterStream.collect(Collectors.toList());

        IntStream.range(0, characters.size()).forEach(i -> assertThat(characters.get(i), is(s.charAt(i))));
    }

}

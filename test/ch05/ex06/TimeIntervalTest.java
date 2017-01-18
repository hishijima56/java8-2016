/*
 * $Header: $
 * $Revision: $
 * $Date: $
*/

package ch05.ex06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import ch05.ex07.TimeInterval;

/**
 * {@link TimeInterval}のテスト・クラスです。
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2017/01/16
 */
public class TimeIntervalTest {

    /**
     * テスト対象クラス
     */
    private TimeInterval target;

    private LocalDateTime testStartDateTime;

    private LocalDateTime testEndDateTime;

    private TimeInterval other;

    private LocalDateTime testOtherStartDateTime;

    private LocalDateTime testOtherEndDateTime;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testStartDateTime = LocalDateTime.of(2017,1,1,12,0,0);
        testEndDateTime = LocalDateTime.of(2017,1,2,1,0,0);

        testOtherStartDateTime = LocalDateTime.of(2017,1,1,15,0,0);
        testOtherEndDateTime = LocalDateTime.of(2017,1,3,11,0,0);
    }

    /**
     * {@link TimeInterval#TimeInterval(java.time.LocalDateTime, java.time.LocalDateTime)} のためのテスト・メソッド。
     */
    @Test
    public void testTimeInterval() {
        target = new TimeInterval(testStartDateTime, testEndDateTime);
        assertThat(target.getStartDateTime(), is(testStartDateTime));
        assertThat(target.getEndDateTime(), is(testEndDateTime));
    }

    /**
     * {@link TimeInterval#TimeInterval(java.time.LocalDateTime, java.time.LocalDateTime)} のためのテスト・メソッド。
     */
    @Test(expected = NullPointerException.class)
    public void testTimeIntervalStartTimeNull() {
        target = new TimeInterval(null, testEndDateTime);
        fail();
    }

    /**
     * {@link TimeInterval#TimeInterval(java.time.LocalDateTime, java.time.LocalDateTime)} のためのテスト・メソッド。
     */
    @Test(expected = NullPointerException.class)
    public void testTimeIntervalEndTimeNull() {
        target = new TimeInterval(testStartDateTime, null);
        fail();
    }

    /**
     * {@link TimeInterval#TimeInterval(java.time.LocalDateTime, java.time.LocalDateTime)} のためのテスト・メソッド。
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTimeIntervalStartTimeIsAfterEndTime() {
        target = new TimeInterval(testEndDateTime, testStartDateTime);
        fail();
    }

    /**
     * {@link TimeInterval#isConflict(TimeInterval)} のためのテスト・メソッド。
     */
    @Test
    public void testIsConflict() {
        target = new TimeInterval(testStartDateTime, testEndDateTime);
        other = new TimeInterval(testOtherStartDateTime, testOtherEndDateTime);

        assertThat(target.isConflict(other), is(true));
    }

}

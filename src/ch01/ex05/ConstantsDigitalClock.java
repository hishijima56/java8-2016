package ch01.ex05;

/*
 * $Header: $
 * $Revision: $
 * $Date: $
 */

/**
 * 定数クラス.
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2015/10/28
 */
public final class ConstantsDigitalClock {

    /**
     * コンストラクタを隠蔽
     */
    private ConstantsDigitalClock(){}

    public static final int FONTSIZE_MIN = 10;
    public static final int FONTSIZE_MAX = 100;
    public static final int FONTSIZE_DEFAULT = 50;
    public static final int FONTSIZE_STEP = 10;

    public static final int WIDTH_MARGIN = 30;
    public static final int HEIGHT_MARGIN = 70;
    public static final int CLOCK_STR_LENGTH = 14;

    public static final int CLOCK_POSITION_X = 0;
    public static final int CLOCK_POSITION_Y = 0;

    public static final String CLOCK_FORMAT = "yyyy/MM/dd hh:mm:ss";

    public static final String TITLE_FRAME = "デジタル時計Swing版";
    public static final int SIZE_COLORCHIP = 10;

}

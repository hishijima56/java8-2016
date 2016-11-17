package ch01.ex05;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;


/*
 * $Header: $
 * $Revision: $
 * $Date: $
 */

/**
 * デジタル時計のプロパティを保持するクラスです.
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2015/10/28
 */
public final class Property {

    /**
     * インスタンス
     */
    private static Property instance;

    /**
     * フォントサイズ
     */
    private int fontSize;

    /**
     * フォント
     */
    private String fontName;

    /**
     * 背景色
     */
    private Color backgroundColor;

    /**
     * 文字色
     */
    private Color fontColor;

    /**
     * X座標
     */
    private int positionX;

    /**
     * Y座標
     */
    private int positionY;

    private Map<String,String> fontNameMap = new HashMap<>();

    private Map<String,Integer> fontSizeMap = new HashMap<>();

    private Map<String,Color> fontColorMap = new HashMap<>();

    private Map<String,Color> backColorMap = new HashMap<>();

    /**
     * preferences
     */
    private Preferences preferences;

    private static final String FONT_KEY = "digitalclock.ishijima.font";
    private static final String FONTSIZE_KEY = "digitalclock.ishijima.fontsize";
    private static final String TEXTCOLOR_KEY = "digitalclock.ishijima.textcolor";
    private static final String BACKGROUNGCOLOR_KEY = "digitalclock.ishijima.backgroundcolor";
    private static final String POSITION_X_KEY = "digitalclock.ishijima.positionx";
    private static final String POSITION_Y_KEY = "digitalclock.ishijima.positiony";


    /**
     * コンストラクタ
     */
    private Property(){
        this.preferences = Preferences.systemNodeForPackage(this.getClass());
        this.fontSize = preferences.getInt(FONTSIZE_KEY, ConstantsDigitalClock.FONTSIZE_DEFAULT);
        this.fontName = preferences.get(FONT_KEY, Font.MONOSPACED);
        this.backgroundColor = new Color(preferences.getInt(BACKGROUNGCOLOR_KEY ,Color.WHITE.getRGB()));
        this.fontColor = new Color(preferences.getInt(TEXTCOLOR_KEY ,Color.RED.getRGB()));
        this.positionX = preferences.getInt(POSITION_X_KEY, ConstantsDigitalClock.CLOCK_POSITION_X);
        this.positionY = preferences.getInt(POSITION_Y_KEY, ConstantsDigitalClock.CLOCK_POSITION_Y);
        initializePropMaps();

    }

    private void initializePropMaps() {
        this.fontNameMap.put(Font.MONOSPACED, Font.MONOSPACED);
        this.fontNameMap.put(Font.SANS_SERIF, Font.SANS_SERIF);
        this.fontNameMap.put(Font.SERIF, Font.SERIF);
        this.fontNameMap.put(Font.DIALOG, Font.DIALOG);

        for (int i = ConstantsDigitalClock.FONTSIZE_MIN; i <= ConstantsDigitalClock.FONTSIZE_MAX; i += ConstantsDigitalClock.FONTSIZE_STEP) {
            this.fontSizeMap.put(String.valueOf(i),i);
        }

        this.fontColorMap.put("黒", Color.BLACK);
        this.fontColorMap.put("白", Color.WHITE);
        this.fontColorMap.put("灰", Color.GRAY);
        this.fontColorMap.put("青", Color.BLUE);
        this.fontColorMap.put("桃", Color.PINK);
        this.fontColorMap.put("赤", Color.RED);
        this.fontColorMap.put("橙", Color.ORANGE);
        this.fontColorMap.put("黄", Color.YELLOW);
        this.fontColorMap.put("緑", Color.GREEN);

        this.backColorMap.put("黒", Color.BLACK);
        this.backColorMap.put("白", Color.WHITE);
        this.backColorMap.put("灰", Color.GRAY);
        this.backColorMap.put("青", Color.BLUE);
        this.backColorMap.put("桃", Color.PINK);
        this.backColorMap.put("赤", Color.RED);
        this.backColorMap.put("橙", Color.ORANGE);
        this.backColorMap.put("黄", Color.YELLOW);
        this.backColorMap.put("緑", Color.GREEN);
    }

    public void savePreferences(){
        this.preferences = Preferences.systemNodeForPackage(this.getClass());
        this.preferences.putInt(FONTSIZE_KEY, fontSize);
        this.preferences.put(FONT_KEY, fontName);
        this.preferences.putInt(BACKGROUNGCOLOR_KEY, backgroundColor.getRGB());
        this.preferences.putInt(TEXTCOLOR_KEY, fontColor.getRGB());
        this.preferences.putInt(POSITION_X_KEY, positionX);
        this.preferences.putInt(POSITION_Y_KEY, positionY);
    }

    /**
     * インスタンスを返します.
     * @return instance
     */
    public static Property getInstance(){
        if(instance == null){
            instance = new Property();
        }
        return instance;
    }

    /**
     * フォントサイズを取得します。
     * @return フォントサイズ
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * フォントサイズを設定します。
     * @param fontSize フォントサイズ
     */
    public void setFontSize(int fontSize) {
        if(fontSize == 0){
            return;
        }
        this.fontSize = fontSize;
    }

    /**
     * フォントを取得します。
     * @return フォント
     */
    public String getFontName() {
        return fontName;
    }

    /**
     * フォントを設定します。
     * @param fontName フォント
     */
    public void setFontName(String fontName) {
        if(fontName == null || fontName.equals("")){
            return;
        }
        this.fontName = fontName;
    }

    /**
     * 背景色を取得します。
     * @return 背景色
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * 背景色を設定します。
     * @param backgroundColor 背景色
     */
    public void setBackgroundColor(Color backgroundColor) {
        if(backgroundColor == null){
            return;
        }
        this.backgroundColor = backgroundColor;
    }

    /**
     * 文字色を取得します。
     * @return 文字色
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * 文字色を設定します。
     * @param fontColor 文字色
     */
    public void setFontColor(Color fontColor) {
        if(fontColor == null){
            return;
        }
        this.fontColor = fontColor;
    }

    /**
     * X座標を取得します。
     * @return X座標
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * X座標を設定します。
     * @param positionX X座標
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Y座標を取得します。
     * @return Y座標
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Y座標を設定します。
     * @param positionY Y座標
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * fontNameMapを取得します。
     * @return fontNameMap
     */
    public Map<String,String> getFontNameMap() {
        return fontNameMap;
    }

    /**
     * fontSizeMapを取得します。
     * @return fontSizeMap
     */
    public Map<String,Integer> getFontSizeMap() {
        return fontSizeMap;
    }

    /**
     * fontColorMapを取得します。
     * @return fontColorMap
     */
    public Map<String,Color> getFontColorMap() {
        return fontColorMap;
    }

    /**
     * backColorMapを取得します。
     * @return backColorMap
     */
    public Map<String,Color> getBackColorMap() {
        return backColorMap;
    }

}

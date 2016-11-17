package ch01.ex05;

import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.Timer;

/*
 * $Header: $
 * $Revision: $
 * $Date: $
 */

/**
 * {@link Window}クラスを使用したデジタル時計です。
 *
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2015/11/25
 */
public class DigitalClockWindow extends JWindow implements ActionListener {

    /**
     * タイマーインターバル
     */
    private int interval = 100;

    /**
     * ポップアップメニュー関連
     */
    private JPopupMenu popupMenu;
    private JMenu fontMenu;
    private JMenu fontSizeMenu;
    private JMenu textColorMenu;
    private JMenu backgroundColorMenu;

    private int drugStartX = 0;
    private int drugStartY = 0;

    /**
     * マウス関連
     */
    private boolean isLeftbuttonClicked = false;

    /**
     * コンストラクタ
     */
    public DigitalClockWindow() {
        super();

        // 位置を指定します。
        Property prop = Property.getInstance();
        setLocation(prop.getPositionX(), prop.getPositionY());

        // サイズを指定します。
        setSize(1000, 500);

        setAlwaysOnTop(true);

        // マウスクリック時のリスナを登録します.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    DigitalClockWindow.this.isLeftbuttonClicked = true;
                    drugStartX = e.getXOnScreen();
                    drugStartY = e.getYOnScreen();
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(DigitalClockWindow.this, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                DigitalClockWindow.this.isLeftbuttonClicked = false;
                Property prop = Property.getInstance();
                Point location = getLocation();
                prop.setPositionX((int) location.getX());
                prop.setPositionY((int) location.getY());
                prop.savePreferences();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (DigitalClockWindow.this.isLeftbuttonClicked) {
                    Property prop = Property.getInstance();
                    int newX = e.getXOnScreen() - drugStartX + prop.getPositionX();
                    int newY = e.getYOnScreen() - drugStartY + prop.getPositionY();
                    setLocation(newX, newY);
                }
            }
        });

        // ポップアップメニューを作成します。
        createPopupMenu();

        // 時計画面を作成し追加します。
        DigitalClockPanel panel = new DigitalClockPanel(this);
        getContentPane().add(panel);
        new Timer(this.interval, panel).start();

    }

    /**
     * ポップアップメニューを作成します.
     */
    private void createPopupMenu() {
        popupMenu = new JPopupMenu();
        Property prop = Property.getInstance();

        // プロパティ用のポップアップを用意する。
        JMenu properyMenu = new JMenu("プロパティ");
        // フォント
        fontMenu = new JMenu("フォント");
        for (String key : prop.getFontNameMap().keySet()) {
            JMenuItem item = new JMenuItem(key);
            item.addActionListener(this);
            fontMenu.add(item);
        }

        // フォントサイズ
        fontSizeMenu = new JMenu("フォントサイズ");
        for (String key : prop.getFontSizeMap().keySet()) {
            JMenuItem item = new JMenuItem(key);
            item.addActionListener(this);
            fontSizeMenu.add(item);
        }

        // 文字色
        textColorMenu = new JMenu("文字色");
        /*
         * ラムダ式で再実装
         */
        prop.getFontColorMap().keySet().forEach(key -> {
            JMenuItem item = new JMenuItem(key, new ColorIcon(prop.getFontColorMap().get(key), ConstantsDigitalClock.SIZE_COLORCHIP));
            item.addActionListener(e -> {
                Property p = Property.getInstance();
                p.setFontColor(p.getFontColorMap().get(e.getActionCommand()));
                update(getGraphics());
            });
            textColorMenu.add(item);
        });

        // 背景色
        backgroundColorMenu = new JMenu("背景色");
        /*
         * ラムダ式で再実装
         */
        prop.getFontColorMap().keySet().forEach(key -> {
            JMenuItem item = new JMenuItem(key, new ColorIcon(prop.getBackColorMap().get(key), ConstantsDigitalClock.SIZE_COLORCHIP));
            item.addActionListener(e -> {
                Property p = Property.getInstance();
                p.setBackgroundColor(p.getBackColorMap().get(e.getActionCommand()));
                update(getGraphics());
            });
            backgroundColorMenu.add(item);
        });

        // プロパティに追加する
        properyMenu.add(fontMenu);
        properyMenu.add(fontSizeMenu);
        properyMenu.add(textColorMenu);
        properyMenu.add(backgroundColorMenu);
        popupMenu.add(properyMenu);

        // 終了用のポップアップを用意する。
        JMenuItem exitMenu = new JMenuItem("終了");
        /*
         * ラムダ式で再実装
         */
        exitMenu.addActionListener(e -> {
            Property property = Property.getInstance();
            Point location = getLocation();
            property.setPositionX((int) location.getX());
            property.setPositionY((int) location.getY());
            property.savePreferences();
            System.exit(-1);
        });
        popupMenu.add(exitMenu);

        add(popupMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Property prop = Property.getInstance();
        if (prop.getFontNameMap().containsKey(e.getActionCommand())) {
            prop.setFontName(e.getActionCommand());
        } else if (prop.getFontSizeMap().containsKey(e.getActionCommand())) {
            prop.setFontSize(Integer.parseInt(e.getActionCommand()));
        }
        update(getGraphics());

    }
}
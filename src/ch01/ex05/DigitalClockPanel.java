package ch01.ex05;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JWindow;

/*
 * $Header: $
 * $Revision: $
 * $Date: $
 */

/**
 * デジタル時計のパネルをSwingで実装します。
 *
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/02/28
 */
public class DigitalClockPanel extends JPanel implements ActionListener {

    private JWindow owner;

    /**
     * 表示時刻
     */
    private String dateTime = "";


    public DigitalClockPanel(DigitalClockWindow owner) {
        super();
        this.owner = owner;
        setBackground(Color.WHITE);
    }


    public DigitalClockPanel() {
        super();
        setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent A00) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // プロパティを初期化します.
        Property prop = Property.getInstance();

        setBackground(prop.getBackgroundColor());

        dateTime = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date());
        g.setColor(prop.getFontColor());

        Font font = new Font(prop.getFontName(), Font.PLAIN, prop.getFontSize());
        g.setFont(font);

        FontMetrics fm = g.getFontMetrics();
        g.drawString(dateTime, (getWidth() - fm.stringWidth(dateTime)) / 2, fm.getAscent() - getInsets().bottom);
        // サイズ調整
        int width = fm.stringWidth(dateTime);
        int ownerWidth = fm.stringWidth(dateTime) + owner.getInsets().left + owner.getInsets().right;
        int height = fm.getAscent() + fm.getDescent() + fm.getLeading() + owner.getInsets().top * 2  + owner.getInsets().bottom * 2;
        setSize(width, height);
        owner.setSize(ownerWidth, height);
    }

    public String getDateTime() {
        return this.dateTime;
    }


}

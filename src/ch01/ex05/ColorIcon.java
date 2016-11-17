package ch01.ex05;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/*
 * $Header: $
 * $Revision: $
 * $Date: $
 */

/**
 * カラーチップ用のアイコンクラス
 * @author Hidetoshi Ishijima
 *
 * @version $Revision: $ $Date: $
 * @since 2016/05/06
 */
public class ColorIcon implements Icon {

    private final Color colorChip;

    private final int size;

    public ColorIcon(Color colorChip,int size) {
        this.colorChip = colorChip;
        this.size = size;
    }

    /**
     * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(colorChip);
        g.fillRect(x, y, getIconWidth(), getIconHeight());
    }

    /**
     * @see javax.swing.Icon#getIconWidth()
     */
    @Override
    public int getIconWidth() {
        return this.size;
    }

    /**
     * @see javax.swing.Icon#getIconHeight()
     */
    @Override
    public int getIconHeight() {
        return this.size;
    }

}

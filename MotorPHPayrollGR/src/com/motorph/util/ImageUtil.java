package com.motorph.util;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.io.File;

/**
 * Utility for scaling and displaying images in JLabels.
 */
public class ImageUtil {

    private ImageUtil() {
        // utility class
    }

    /**
     * Loads an image from the given file path and scales it to fit the JLabel,
     * preserving aspect ratio. Sets the icon on the label.
     *
     * @param filePath the absolute or relative path to the image file
     * @param label    the JLabel to set the icon on
     */
    public static void scaleToLabel(String filePath, JLabel label) {
        if (filePath == null || filePath.isEmpty()) {
            label.setIcon(null);
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            label.setIcon(null);
            return;
        }
        ImageIcon icon = new ImageIcon(filePath);
        int labelWidth = label.getWidth() > 0 ? label.getWidth() : label.getPreferredSize().width;
        int labelHeight = label.getHeight() > 0 ? label.getHeight() : label.getPreferredSize().height;
        if (labelWidth <= 0) labelWidth = 100;
        if (labelHeight <= 0) labelHeight = 100;

        float aspectRatio = (float) icon.getIconWidth() / Math.max(1, icon.getIconHeight());
        int targetWidth = labelWidth;
        int targetHeight = labelHeight;
        if ((float) labelWidth / labelHeight > aspectRatio) {
            targetWidth = (int) (labelHeight * aspectRatio);
        } else {
            targetHeight = (int) (labelWidth / aspectRatio);
        }

        Image scaled = icon.getImage().getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaled));
        label.setText("");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
    }
}

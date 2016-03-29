package com.hisun.common.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 
 * @类名： ImageUtil.java
 * 
 * @描述：ImageUtil @作者： PAUL @修改日期： 2016年3月29日
 *
 */
public class ImageUtil
{
    public static void imgCut(String srcImageFile, int x, int y, int desWidth, int desHeight)
    {
        try
        {
            Image img;
            ImageFilter cropFilter;
            BufferedImage bi = ImageIO.read(new File(srcImageFile + "_src.jpg"));
            int srcWidth = bi.getWidth();
            int srcHeight = bi.getHeight();
            if (srcWidth >= desWidth && srcHeight >= desHeight)
            {
                Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
                cropFilter = new CropImageFilter(x, y, desWidth, desHeight);
                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
                BufferedImage tag = new BufferedImage(desWidth, desHeight, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                // 输出文件
                ImageIO.write(tag, "JPEG", new File(srcImageFile + ".jpg"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

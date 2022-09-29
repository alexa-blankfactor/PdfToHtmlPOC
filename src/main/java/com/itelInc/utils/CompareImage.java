package com.itelInc.utils;


import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareImage {

    public Boolean compare(String expectedImagePath, String actualImagePath){
        BufferedImage expectedImage = null;
        BufferedImage actualImage = null;
        try {
            expectedImage = ImageIO.read(new File(expectedImagePath));
            actualImage = ImageIO.read(new File(actualImagePath));
            ImageDiffer imgDiff = new ImageDiffer();
            ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
            return  diff.hasDiff();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}

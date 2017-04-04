package tech.acodesigner.util;

import java.io.File;

/**
 * Created by 77239 on 2017/4/4/0004.
 */
public class ImagesUtil {

    public static String[] getImages(String path) {
        File imagesFolder = new File(path);
        String[] images = imagesFolder.list();
        return images;
    }

}

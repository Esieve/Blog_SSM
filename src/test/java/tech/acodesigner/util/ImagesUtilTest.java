package tech.acodesigner.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 77239 on 2017/4/4/0004.
 */
public class ImagesUtilTest {
    @Test
    public void getImages() throws Exception {
        String[] images = ImagesUtil.getImages("../images/user");
        for (String image : images) {
            System.out.println(image);
        }
    }

}
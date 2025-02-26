package com.hzyxsj.app;
import com.hzyxsj.*;

import java.io.IOException;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */

public class In {
    /**
     * .
     * @param imgpath 源图片地址
     * @param outimagepath 输出图片地址
     * @param message 隐藏信息
     */
    public void EncodeMegToImg(String message,String imgpath,String outimagepath ) throws IOException {
        new ImageCode( ).CodemessageToImage(message,imgpath,outimagepath);
        System.out.println("已经成功隐写，新图片位置："+outimagepath);
    }
}

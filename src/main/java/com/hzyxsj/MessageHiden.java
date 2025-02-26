package com.hzyxsj;

import java.nio.charset.StandardCharsets;

/**
 * 作者：宇宙超级无敌大马猴
 * 姓：亥
 * 字：子曜
 * 号：栖逸居士
 * 版本号：随缘
 */
public class MessageHiden {
    public String hidemessage(String message) {
        byte[] bytes= message.getBytes(StandardCharsets.UTF_8);
        String binary="";
        String temp;
        for(byte b:bytes){
              temp = Integer.toBinaryString(b & 0xFF);
              while(temp.length()<8){
                  temp="0"+temp;
              }
              binary=binary+temp;
        }

        return binary;

    }

}
//[84, 104, 105, 115, 32, 105, 115, 32, 97, 32, 116, 101, 115, 116]

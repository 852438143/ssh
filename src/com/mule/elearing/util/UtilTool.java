package com.mule.elearing.util;

import java.util.UUID;

/**
 * Created by 85243 on 2017/4/21.
 */
public class UtilTool {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}

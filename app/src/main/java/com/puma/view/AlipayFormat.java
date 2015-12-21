package com.puma.view;

import java.text.DecimalFormat;

/**
 * Created by baidu on 15/12/20.
 */
public class AlipayFormat implements FormateContentStrategy<Float>{

    @Override
    public String toWantString(Float f) {
        DecimalFormat decimalFormat = new DecimalFormat(".00"); //构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p = decimalFormat.format(f);
        return p;
    }
}

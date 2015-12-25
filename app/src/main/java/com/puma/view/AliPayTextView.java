package com.puma.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by liushaogeng on 15/12/20.
 * 一个可以实现类似支付宝金额动画变化的textview
 * 内容格式的改变可以自定义FormateContentStrategy来修改
 */
public class AliPayTextView extends TextView {
    private static final String TAG = "AliPayTextView";
    private static final float BASEVALUE = 5000;
    private static int s_aaa;
    private FormateContentStrategy<Float> formateContentStrategy;
    private ObjectAnimator oa;
    private float finalValue; // 最终的text值
    public AliPayTextView(Context context) {
        super(context);
    }

    public AliPayTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AliPayTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // text的值从fromMoney变为finalMoney,一种动画变化效果
    public void startAnimation(float fromMoney, float finalMoney) {
        if(oa!=null && oa.isRunning()) return;
        finalValue = finalMoney;
        oa = ObjectAnimator.ofFloat(this, "money", fromMoney, finalMoney)
                .setDuration(1000);

        oa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (Float) animation.getAnimatedValue();
                Log.d(TAG, "cVal = " + cVal);
                String result;
                if (formateContentStrategy != null) {
                    result = formateContentStrategy.toWantString(cVal);
                } else {
                    result = "" + cVal;
                }
                AliPayTextView.this.setText(result);
            }
        });
        oa.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (finalValue / BASEVALUE == 0) {
                    AliPayTextView.this.setTextColor(Color.LTGRAY);
                }else if (finalValue / BASEVALUE == 1) {
                    AliPayTextView.this.setTextColor(Color.MAGENTA);
                } else if (finalValue / BASEVALUE == 2) {
                    AliPayTextView.this.setTextColor(Color.BLACK);
                } else if (finalValue / BASEVALUE == 3) {
                    AliPayTextView.this.setTextColor(Color.WHITE);
                } else if (finalValue / BASEVALUE == 4) {
                    AliPayTextView.this.setTextColor(Color.YELLOW);
                }else if (finalValue / BASEVALUE == 5) {
                    AliPayTextView.this.setTextColor(Color.RED);
                }else {
                    AliPayTextView.this.setTextColor(Color.CYAN);
                }
            }
        });
        oa.start();
    }

    public FormateContentStrategy<Float> getFormateContentStrategy() {
        return formateContentStrategy;
    }

    public void setFormateContentStrategy(FormateContentStrategy<Float> formateContentStrategy) {
        this.formateContentStrategy = formateContentStrategy;
    }
}

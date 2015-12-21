package com.puma.control;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gisinc.androidexamples.androidtogglebutton.R;
import com.puma.view.SettingsToggle;
import com.puma.view.AliPayTextView;
import com.puma.view.AlipayFormat;
import com.puma.view.FormateContentStrategy;

public class MyActivity extends Activity {

    AliPayTextView tv;
    float fromMoney;
    float finalMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        tv = (AliPayTextView) findViewById(R.id.tv_money);
        tv.setText("" + 1000.00);
        FormateContentStrategy<Float> floatFormateContentStrategy = new AlipayFormat();
//        tv.startAnimation(10F, 5000F);
        tv.setFormateContentStrategy(floatFormateContentStrategy);
        SettingsToggle st = (SettingsToggle) findViewById(R.id.settings1);
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromMoney = Float.valueOf(tv.getText().toString());
                finalMoney = fromMoney * 5 > 1000000 ? 1000 : fromMoney * 5;
                tv.startAnimation(fromMoney, finalMoney);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
/*
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
*/

        return super.onOptionsItemSelected(item);
    }
}

package teko.biz.test.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import teko.biz.test.ui.MapsActivity;
import teko.biz.test.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        startActivity(new Intent(SplashActivity.this,MapsActivity.class));
    }
}

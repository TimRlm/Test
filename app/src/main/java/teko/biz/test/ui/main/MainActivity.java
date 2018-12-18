package teko.biz.test.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import teko.biz.test.R;
import teko.biz.test.ui.HzFragment;
import teko.biz.test.ui.base.BaseActivity;
import teko.biz.test.ui.news.NewsFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private NewsFragment newsFragment = new NewsFragment();

    @Override
    protected void init() {
        ((BottomNavigationView) findViewById(R.id.navigation)).setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.cont,newsFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().add(R.id.cont,newsFragment).commit();
                return true;
            case R.id.navigation_person:
                setTitle("asdasdasd");
                getSupportFragmentManager().beginTransaction().replace(R.id.cont,new HzFragment()).commit();
                return true;
        }
        return false;
    }

    @Override
    protected boolean needBack() { return false; }

    @Override
    protected int getLayout() { return R.layout.activity_main; }
}

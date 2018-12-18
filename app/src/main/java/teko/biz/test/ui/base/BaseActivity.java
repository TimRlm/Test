package teko.biz.test.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import teko.biz.test.R;

public abstract class BaseActivity extends AppCompatActivity {
    @Nullable @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        init();
        setActionBar(mToolbar);
        if (needBack()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected abstract boolean needBack();

    protected abstract void init();

    protected abstract int getLayout();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
}

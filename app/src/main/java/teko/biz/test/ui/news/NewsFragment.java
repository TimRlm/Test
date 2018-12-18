package teko.biz.test.ui.news;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import teko.biz.test.R;
import teko.biz.test.data.model.Action;

public class NewsFragment extends Fragment implements NewsView, SwipeRefreshLayout.OnRefreshListener, NewsAdapter.OnClickListener {
    @BindView(R.id.refresh) SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.rv) RecyclerView rv;

    private NewsPresenter mPresenter;
    private NewsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, root);
        mPresenter = new NewsPresenter(this);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rv.setLayoutManager(gridLayoutManager);
        mAdapter = new NewsAdapter();
        rv.setAdapter(mAdapter);
        mAdapter.setOnClickListener(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setRefreshing(true);
        mPresenter.load();
    }

    @Override
    public void click(String text, String path) {
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_TEXT,text + "\n" + path);
//        intent.setType("text/plain");
//        startActivity(intent);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://drive.google.com/viewerng/viewer?embedded=true&url=" +
                "smart-resto.ru/bot255409962:AAGRj65bieMkt2JV4mBRrxPHWgEZP08hRc8/reports_okdesk.php?token=dlaejlf;fsokf&date=yesterday&type=closed"));
        startActivity(intent);
    }

    @Override
    public void updList(List<Action> r) {
        swipeRefreshLayout.setRefreshing(false);
        mAdapter.upd(r);
        rv.scrollTo(0,0);
    }

    @Override
    public void error() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.load();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.destroy();
    }
}

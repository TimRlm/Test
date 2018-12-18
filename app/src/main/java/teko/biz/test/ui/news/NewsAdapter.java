package teko.biz.test.ui.news;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import teko.biz.test.R;
import teko.biz.test.data.model.Action;

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsView> {
    private List<Action> actions = new ArrayList<>();
    private OnClickListener onClickListener = (t,d)->{};

    @NonNull
    @Override
    public NewsView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NewsView(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_news, viewGroup,false));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsView view, int i) {
        view.textView.setText(actions.get(i).description);
        Glide.with(view.imageView)
                .load(actions.get(i).image)
                .apply(RequestOptions.placeholderOf(R.drawable.common_full_open_on_phone)
                        .error(R.drawable.common_google_signin_btn_icon_dark_normal))
                .into(view.imageView);
    }

    public void upd(List<Action> actions){
        this.actions.addAll(0,actions);
        notifyItemRangeInserted(0,this.actions.size());
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }

    class NewsView extends RecyclerView.ViewHolder{
        @BindView(R.id.img)
        ImageView imageView;
        @BindView(R.id.text)
        TextView textView;
        NewsView(View view){
            super(view);
            ButterKnife.bind(this,view);
            view.setOnClickListener(v->{
                onClickListener.click(textView.getText().toString(),actions.get(getAdapterPosition()).image);
            });
        }
    }

    interface OnClickListener{
        void click(String text, String url);
    }
}

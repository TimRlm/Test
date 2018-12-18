package teko.biz.test.ui.news;

import java.util.List;

import teko.biz.test.data.model.Action;

interface NewsView {
    void updList(List<Action> r);

    void error();
}

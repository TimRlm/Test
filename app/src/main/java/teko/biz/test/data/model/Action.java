package teko.biz.test.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Action {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("action_order")
    @Expose
    public String actionOrder;
    @SerializedName("image")
    @Expose
    public String image;
}

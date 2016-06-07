package wecaht.my060702;

/**
 * Created by Administrator on 2016/6/7 0007.
 */
public class ItemBean {
    public int itemImageResid;
    public String itemTitle;
    public String itemContent;

    public ItemBean(String itemContent, String itemTitle, int itemImageResid) {
        this.itemContent = itemContent;
        this.itemTitle = itemTitle;
        this.itemImageResid = itemImageResid;
    }
}

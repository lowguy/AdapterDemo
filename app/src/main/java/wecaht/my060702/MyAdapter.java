package wecaht.my060702;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/6/7 0007.
 */
public class MyAdapter extends BaseAdapter {
    private List<ItemBean> mList;
    private LayoutInflater mInflater;
    private long mSumTime;
    public MyAdapter(Context context,List<ItemBean> list){
        this.mInflater = LayoutInflater.from(context);
        this.mList = list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //逗逼 没有优化处理 179065418
//        long start = System.nanoTime();
//        View view = mInflater.inflate(R.layout.item,null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
//        TextView title = (TextView) view.findViewById(R.id.iv_title);
//        TextView content = (TextView) view.findViewById(R.id.iv_content);
//        ItemBean bean = mList.get(position);
//        imageView.setImageResource(bean.itemImageResid);
//        title.setText(bean.itemTitle);
//        content.setText(bean.itemContent);
//        long end = System.nanoTime();
//        long dValue = end - start;
//        mSumTime += dValue;
//        Log.d("hyp2", String.valueOf(mSumTime));
//        return view;
        //普通式 利用了缓存 但findViewById依然会浪费大量时间 148142138
//        long start = System.nanoTime();
//        if(convertView == null){
//            convertView = mInflater.inflate(R.layout.item,null);
//        }
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_image);
//        TextView title = (TextView) convertView.findViewById(R.id.iv_title);
//        TextView content = (TextView) convertView.findViewById(R.id.iv_content);
//        ItemBean bean = mList.get(position);
//        imageView.setImageResource(bean.itemImageResid);
//        title.setText(bean.itemTitle);
//        content.setText(bean.itemContent);
//        long end = System.nanoTime();
//        long dValue = end - start;
//        mSumTime += dValue;
//        Log.d("hyp1", String.valueOf(mSumTime));
//        return convertView;
        //文艺式 117726355
//        long start = System.nanoTime();
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item,null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.iv_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.iv_content);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ItemBean bean = mList.get(position);
        viewHolder.imageView.setImageResource(bean.itemImageResid);
        viewHolder.title.setText(bean.itemTitle);
        viewHolder.content.setText(bean.itemContent);
//        long end = System.nanoTime();
//        long dValue = end - start;
//        mSumTime += dValue;
//        Log.d("hyp", String.valueOf(mSumTime));
        return convertView;

    }
    class ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}

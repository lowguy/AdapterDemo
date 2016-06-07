package wecaht.my060702;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据适配器
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ItemBean> itemBeanList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            itemBeanList.add(new ItemBean("作者是俞甲子，石凡，潘爱民" + i,"程序员的自我修养" + i,  R.mipmap.ic_launcher));
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this,itemBeanList));
    }
}

package sfhw.com.demosectionlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hb.views.PinnedSectionListView;

import java.util.ArrayList;

import sfhw.com.demosectionlistview.bean.GroupInfo;
import sfhw.com.demosectionlistview.bean.StudentInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PinnedSectionListView mListView = (PinnedSectionListView) findViewById(R.id.main_lv_glass);

        //加载数据 group 类型GroupInfo    child 类型StudentInfo
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            GroupInfo groupInfo = new GroupInfo(i + "年级","北京三丰户外联盟");
            objects.add(groupInfo);

            //子元素
            for (int j = 0; j < 30 ;j++){
                StudentInfo studentInfo = new StudentInfo("学生" + i);
                objects.add(studentInfo);
            }
        }

        MyAdapter adapter = new MyAdapter(objects);

        mListView.setAdapter(adapter);
    }
}

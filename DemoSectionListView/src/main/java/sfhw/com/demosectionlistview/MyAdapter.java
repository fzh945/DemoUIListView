package sfhw.com.demosectionlistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hb.views.PinnedSectionListView;

import java.util.ArrayList;

import sfhw.com.demosectionlistview.bean.GroupInfo;
import sfhw.com.demosectionlistview.bean.StudentInfo;

/**
 * Created by fzh on 2016/6/5.
 */
public class MyAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter{

    private static final int ITEM_GROUP = 0;
    private static final int ITEM_STUDENT = 1;
    ArrayList<Object> list;

    public MyAdapter(ArrayList<Object> objects) {
        list = objects;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        Object object = getItem(position);
        if(object.getClass() == GroupInfo.class){
            return ITEM_GROUP;
        }else{
            return ITEM_STUDENT;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return ITEM_GROUP == viewType;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //数据
        Object data = getItem(position);

        //视图
        int itemViewType = getItemViewType(position);

        if(itemViewType == ITEM_GROUP) {
            convertView = View.inflate(parent.getContext(),R.layout.item_group,null);

            GroupInfo groupInfo = (GroupInfo) data;
            TextView textView = (TextView) convertView.findViewById(R.id.item_group);
            textView.setText(groupInfo.name + groupInfo.desc);
        }else if(itemViewType == ITEM_STUDENT){
            convertView = View.inflate(parent.getContext(),R.layout.item_student,null);

            StudentInfo studentInfo = (StudentInfo) data;
            TextView textView = (TextView) convertView.findViewById(R.id.item_student);
            textView.setText(studentInfo.name);
        }

        return convertView;
    }

}

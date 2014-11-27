package com.mtetno.tabswipe;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivityAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflator;
    private static String TAG = "ExamsActivityAdapter";
    private ArrayList<TestModel> mExams;
    private ViewGroup mParent;
    String[] web = { "GRE", "SAT", "ACT", "GMAT"

    };
    int[] imageId = { R.drawable.course, R.drawable.course, R.drawable.course,
            R.drawable.course, R.drawable.course, R.drawable.course,
            R.drawable.course, R.drawable.course, R.drawable.course,
            R.drawable.course, R.drawable.course, R.drawable.course,
            R.drawable.course, R.drawable.course, R.drawable.course

    };
    public ListActivityAdapter(Context context, ArrayList<TestModel> exams) {
        // TODO Auto-generated constructor stub
        this.mContext = context;
        mInflator = LayoutInflater.from(context);
        this.mExams = exams;

    }

    @Override
    public int getCount() {
        return mExams.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Planet to display
        TestModel item = mExams.get(position);
        mParent = parent;
        TextView examName;
        GridView gridView ;
        Button seeAll;

        // Create a new row view
        if (convertView == null) {
            convertView = mInflator.inflate(R.layout.category_gridview_activity_row, null);

            // Find the child views.
            examName = (TextView) convertView.findViewById(R.id.textView1);
            seeAll = (Button) convertView.findViewById(R.id.button1);
            gridView=(GridView)convertView.findViewById(R.id.grid1);
            convertView.setTag(new Holder(examName, seeAll,gridView,position));
        }

        // Reuse existing row view
        else {
            // Because we use a ViewHolder, we avoid having to call
            // findViewById().
            Holder viewHolder = (Holder) convertView.getTag();

            examName = viewHolder.getExamName();
            gridView = viewHolder.getGridView();
            seeAll = viewHolder.getIcon();
        }

        examName.setText(item.getSubjectName());
 
        CategoryGridViewAdapter adapter = new CategoryGridViewAdapter(
               mContext, web, imageId);
       
        
        if(adapter!=null)
        gridView.setAdapter(adapter);
       
        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                View clickedView = v;
                //
                 Holder holderItem =(Holder) clickedView.getTag();
                 
//                 ImageView icon=(ImageView)v.findViewById(R.id.icon);
//                icon.setImageResource(R.drawable.arrow__select);
                //
                // clickedView.setBackgroundColor(Color.GREEN);
                ((ListView) mParent).setItemChecked(holderItem.getPosition(), true);

            }
        });

        return convertView;

    }

    public class Holder {

        private TextView examName;

        private Button seeAll;

        private int position;
        
        private GridView gridView;
        
        

        public Button getSeeAll() {
            return seeAll;
        }

        public void setSeeAll(Button seeAll) {
            this.seeAll = seeAll;
        }

        public GridView getGridView() {
            return gridView;
        }

        public void setGridView(GridView gridView) {
            this.gridView = gridView;
        }

        public Holder() {
        }

        public Holder(TextView tvName, Button icn, GridView grdView,int pos) {

            this.examName = tvName;

            this.seeAll = icn;

            this.position = pos;
            
            this.gridView = grdView;
        }

        public TextView getExamName() {
            return examName;
        }

        public void setExamName(TextView graphName) {
            this.examName = graphName;
        }

        public Button getIcon() {
            return seeAll;
        }

        public void setIcon(Button icon) {
            this.seeAll = icon;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }
}

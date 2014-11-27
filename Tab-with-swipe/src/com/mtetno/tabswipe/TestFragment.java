package com.mtetno.tabswipe;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TestFragment extends Fragment {
    private ListView mExamsListView;
    private ArrayList<TestModel> mTestModel=new ArrayList<TestModel>();
    private ArrayList<String> mExamsDataArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_test, container,
                false);
        mExamsListView = (ListView) rootView.findViewById(R.id.listView1);
        mExamsDataArrayList = new ArrayList<String>();
        // HardCording the Arraylist -- > need to populate the listview from
        // webservices
        mExamsDataArrayList.add("Test 1");
        mExamsDataArrayList.add("Test 2");
        mExamsDataArrayList.add("Test 3");
        mExamsDataArrayList.add("Test 4");
        mExamsDataArrayList.add("Test 5");

        TestModel testModel = new TestModel();
        testModel.setItems(mExamsDataArrayList);
        ;
        testModel.setSubjectName("Subject1");

        mTestModel.add(testModel);
        mTestModel.add(testModel);

        ListActivityAdapter examsActivityAdapter = new ListActivityAdapter(
                getActivity(), mTestModel);

        // ArrayAdapter<String> examsListAdapter = new ArrayAdapter<>(
        // getActivity(), android.R.layout.simple_list_item_1,
        // mExamsDataArrayList);
        //
         mExamsListView.setAdapter(examsActivityAdapter);
        //
        // mExamsListView.setOnItemClickListener(new OnItemClickListener() {
        //
        // @Override
        // public void onItemClick(AdapterView<?> parent, View view,
        // int position, long id) {
        // // TODO Auto-generated method stub
        //
        //
        // }
        // });

        return rootView;
    }
}

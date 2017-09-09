package com.timetracker.kunal.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class TimeTracker extends AppCompatActivity {

    TimeTrackerAdapter timeTrackerAdapter;
    private TimeTrackerDatabaseHelper databaseHelper;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_list_item);

        /*i=getIntent();
        time=i.getStringExtra("time");
        note=i.getStringExtra("note");*/

        databaseHelper = new TimeTrackerDatabaseHelper(this);
        ListView listView = (ListView) findViewById(R.id.times_list);
        timeTrackerAdapter = new TimeTrackerAdapter(this,databaseHelper.getTimeRecordList());
        //timeTrackerAdapter = new TimeTrackerAdapter();
        listView.setAdapter(timeTrackerAdapter);
    }

    public void onAddButton (View view) {
        i = new Intent(this,AddTimeActivity.class);

        final int result = 1;

        startActivityForResult(i,result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        String time = data.getStringExtra("time");
        String note = data.getStringExtra("note");

        databaseHelper.saveTimeRecord(time,note);
        timeTrackerAdapter.changeCursor(databaseHelper.getTimeRecordList());

        /*timeTrackerAdapter.addTimeRecord(new TimeRecord(time,note));

        timeTrackerAdapter.notifyDataSetChanged();*/

    }
}

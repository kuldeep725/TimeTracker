package com.timetracker.kunal.timetracker;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TimeTrackerAdapter extends CursorAdapter {

    TimeTrackerAdapter (Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView timeTextView = (TextView) view.findViewById(R.id.time_view);
        timeTextView.setText(cursor.getString(cursor.getColumnIndex("time")));

        TextView notesTextView = (TextView) view.findViewById(R.id.notes_view);
        notesTextView.setText(cursor.getString(cursor.getColumnIndex("note")));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_view,parent,false);
        return view;

    }
    /*private ArrayList<TimeRecord> times = new ArrayList<TimeRecord>();

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int index) {
        return getItem(index);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @Override
    public View getView(int index, View view, ViewGroup parent) {

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.list_view,parent,false);
        }
        TimeRecord time = times.get(index);

        TextView timeTextView = (TextView) view.findViewById(R.id.time_view);
        timeTextView.setText(time.getTime());

        TextView notesTextView = (TextView) view.findViewById(R.id.notes_view);
        notesTextView.setText(time.getNotes());
        return view;

    }

    public TimeTrackerAdapter() {

       /* times.add(new TimeRecord("38:23","Feeling good !"));
        times.add(new TimeRecord("49:01","Tired. Need more caffeine"));
        times.add(new TimeRecord("26:21","I'm rocking it !"));
        times.add(new TimeRecord("29:42","Lost some time on the hills, but pretty good."));

    }

    public void addTimeRecord(TimeRecord record) {

            times.add(record);

    }*/

}

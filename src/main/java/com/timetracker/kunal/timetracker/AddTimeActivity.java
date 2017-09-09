package com.timetracker.kunal.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by kunal on 8/6/17.
 */

public class AddTimeActivity extends AppCompatActivity {
    TimeRecord record;
    TimeTracker timeTracker;
    Intent i;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_text_layout);
    }

    public void onSaveButton (View view) {
        EditText time_text = (EditText)findViewById(R.id.time_text);
        EditText note_text = (EditText)findViewById(R.id.note_text);

        i = getIntent();
        i.putExtra("time",time_text.getText().toString());
        i.putExtra("note",note_text.getText().toString());
        this.setResult(RESULT_OK,i);
        finish();

    }

    public void onCancelButton (View view) {
        finish();
    }

}

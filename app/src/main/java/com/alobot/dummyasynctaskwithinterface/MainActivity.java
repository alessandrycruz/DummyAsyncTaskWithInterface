package com.alobot.dummyasynctaskwithinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alobot.dummyasynctaskwithinterface.Interfaces.Base_Interface;
import com.alobot.dummyasynctaskwithinterface.TaskSet.Dummy_TaskSet;

public class MainActivity extends AppCompatActivity {
    private Dummy_TaskSet mDummyTaskSet;
    private TextView mTextViewTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDummyTaskSet = new Dummy_TaskSet();
        mTextViewTag = (TextView) findViewById(R.id.text_view_tag);
    }

    public void onExecuteClick(View view) {
        mDummyTaskSet.executeDummyTask(new Base_Interface() {
            @Override
            public void onSuccess(String someValue) {
                Toast.makeText(MainActivity.this, "Task Result: " + someValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String someValue) {
                Toast.makeText(MainActivity.this, "Task Result: " + someValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRunning() {
                Toast.makeText(MainActivity.this, "Task is Running.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(MainActivity.this, "Task was Cancelled.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPublishProgress(Integer someValue) {
                mTextViewTag.setText("Task Progress: " + someValue);
            }
        });
    }

    public void onCancelClick(View view) {
        mDummyTaskSet.cancelDummyTask();
    }
}

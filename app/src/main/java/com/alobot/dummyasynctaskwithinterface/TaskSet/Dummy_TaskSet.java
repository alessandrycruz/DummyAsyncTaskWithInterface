package com.alobot.dummyasynctaskwithinterface.TaskSet;

import android.os.AsyncTask;

import com.alobot.dummyasynctaskwithinterface.Interfaces.Base_Interface;
import com.alobot.dummyasynctaskwithinterface.Tasks.Dummy_Task;

public class Dummy_TaskSet {
    private AsyncTask mDummyTask;

    public void executeDummyTask(final Base_Interface baseInterface) {
        if (mDummyTask != null && mDummyTask.getStatus() == AsyncTask.Status.RUNNING) {
            baseInterface.onRunning();
        } else {
            mDummyTask = new Dummy_Task(baseInterface).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    public void cancelDummyTask() {
        if (mDummyTask != null && mDummyTask.getStatus() == AsyncTask.Status.RUNNING) {
            mDummyTask.cancel(true);
        }
    }
}

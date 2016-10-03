package com.alobot.dummyasynctaskwithinterface.Tasks;

import android.os.AsyncTask;

import com.alobot.dummyasynctaskwithinterface.Interfaces.Base_Interface;

public class Dummy_Task extends AsyncTask<Void, Integer, String> {
    private Base_Interface mBaseInterface;

    public Dummy_Task(Base_Interface baseInterface) {
        mBaseInterface = baseInterface;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        for (int i = 0; i < 100000; i++) {
            publishProgress(i);
        }

        return "SUCCESS";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        mBaseInterface.onPublishProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if (result != null && !result.isEmpty() && result.equalsIgnoreCase("SUCCESS")) {
            mBaseInterface.onSuccess(result);
        } else {
            mBaseInterface.onFail(result);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        mBaseInterface.onCancel();
    }
}
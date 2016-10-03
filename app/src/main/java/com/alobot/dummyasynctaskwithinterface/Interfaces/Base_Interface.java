package com.alobot.dummyasynctaskwithinterface.Interfaces;

public interface Base_Interface {
    void onSuccess(String someValue);

    void onFail(String someValue);

    void onRunning();

    void onCancel();

    void onPublishProgress(Integer someValue);
}
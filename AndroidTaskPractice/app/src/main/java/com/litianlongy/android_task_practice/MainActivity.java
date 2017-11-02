package com.litianlongy.android_task_practice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.litianlongy.android_task_practice.Task.SelfTask;
import com.litianlongy.android_task_practice.Task.TaskRunner;

/**
 * @author litianlongy
 */

public class MainActivity extends AppCompatActivity implements TaskRunner{

    // Create a handler for posting messages to the UI thread.
    private Handler m_handler = new Handler(Looper.getMainLooper());

    private enum Tasks {
        task1, task2, task3
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void runTask(Object id, Object... args) {
        switch ((Tasks) id) {
            case task1:
                break;
            case task2:
                break;
            case task3:
                break;
        }
    }

    private void execBG(Object id, Object... args) {
        new Thread(new SelfTask(this, id, args)).start();
    }

    private  void execUI(Object id, Object... args) {
        execUIDelayed(0, id, args);
    }

    private void execUIDelayed(long delayTime, Object id, Object... args) {
        // Create a task that call back to ourselves.
        SelfTask selfTask = new SelfTask(this, id, args);

        // Post the task to a main handler to come back on app UI thread.
        if(delayTime == 0) {
            m_handler.post(selfTask);
        } else {
            m_handler.postDelayed(selfTask, delayTime);
        }
    }
}

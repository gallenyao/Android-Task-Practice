package com.litianlongy.android_task_practice.Task;

import java.util.concurrent.Callable;

/**
 * @author litianlongy
 */

public class SelfTask implements Runnable, Callable<Void> {
    private TaskRunner m_taskRunner;
    private Object m_id;
    private Object[] m_args;

    public SelfTask(TaskRunner taskRunner, Object id, Object[] args) {
        m_taskRunner = taskRunner;
        m_id = id;
        m_args = args;

    }

    @Override
    public void run() {
        m_taskRunner.runTask(m_id, m_args);
    }

    @Override
    public Void call() throws Exception {
        run();
        return null;
    }
}

package com.luoyan.thread;

public class QueryFromDBAction implements QueryAction {

    @Override
    public void execute(Context context) {
        try {

            Thread.sleep(1000L);
            context.setName(Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void execute() {
        ActionContext.getContext().setName(Thread.currentThread().getName());

    }
}

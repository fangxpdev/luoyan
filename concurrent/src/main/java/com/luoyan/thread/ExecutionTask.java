package com.luoyan.thread;

import javax.swing.*;

public class ExecutionTask implements Runnable {

    private QueryAction queryAction = new QueryFromDBAction();


    private QueryAction httpAction = new queryFromHttpAction();



    @Override
    public void run() {
//        Context context = new Context();
//        queryAction.execute(context);
//        System.out.println("db query success ,name " + context.getName());
//        httpAction.execute(context);
//        System.out.println("http query success,cardId" + context.getCardId());
        Context context = ActionContext.getContext();
        queryAction.execute();
        System.out.println("db query success ,name " + context.getName());
        httpAction.execute();
        System.out.println("http query success,cardId" + context.getCardId());
    }
}

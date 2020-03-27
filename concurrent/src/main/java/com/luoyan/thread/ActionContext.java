package com.luoyan.thread;

public class ActionContext {

    private static final ThreadLocal<Context> contextHolder = ThreadLocal.withInitial(() -> new Context());

    public static Context getContext() {
        return contextHolder.get();
    }

    public static void setContext(Context context) {
        contextHolder.set(context);
    }
}

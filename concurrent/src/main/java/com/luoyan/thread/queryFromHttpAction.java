package com.luoyan.thread;

public class queryFromHttpAction implements QueryAction {

    @Override
    public void execute(Context context) {
        String name = context.getName();
        context.setCardId(getCardId(name));
    }

    @Override
    public void execute() {
        ActionContext.getContext().setCardId("33222" + Thread.currentThread().getId());
    }

    private String getCardId(String name) {

        return "332321" + Thread.currentThread().getId();
    }
}

package com.woogie.calculator.ui;

public abstract class AbstractCalculatorBehavior implements CalculatorBehavior {
    abstract protected void doOnStart();

    abstract protected void doOnComplete();

    abstract protected void doOnError(RuntimeException ex);

    abstract protected boolean complete();

    @Override
    public void run() {
        while (complete()) {
            try {
                doOnStart();
                doOnComplete();
            } catch (RuntimeException ex) {
                doOnError(ex);
            } catch (Exception ex) {
                System.out.println("오류 발생으로 시스템 종료, message: " + ex.getMessage());
            }
        }
    }
}

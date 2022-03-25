package com.woogie.calculator.ui;

public abstract class AbstractCalculatorBehavior implements CalculatorBehavior {
    abstract protected void start();

    abstract protected void complete();

    abstract protected void error(RuntimeException ex);

    @Override
    public void run() {
        while (true) {
            try {
                start();
                complete();
            } catch (RuntimeException ex) {
                error(ex);
            } catch (Exception ex) {
                System.out.println("오류 발생으로 시스템 종료, message: " + ex.getMessage());
            }
        }
    }
}

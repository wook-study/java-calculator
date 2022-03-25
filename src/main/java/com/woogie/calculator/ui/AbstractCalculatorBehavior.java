package com.woogie.calculator.ui;

/**
 * 계산기 어플리케이션의 추상클래스 (실행에 필요한 기능을 모아 템플릿화 함)
 */
public abstract class AbstractCalculatorBehavior implements CalculatorBehavior {
    /**
     * 계산기 실행 완료 여부를 결정
     */
    abstract protected boolean isCompleted();

    /**
     * 계산기가 최초 실행하면 동작
     */
    abstract protected void start();

    /**
     * 계산기 실행이 완료되면 동작
     */
    abstract protected void complete();

    /**
     * 예외가 발생했을때 동작
     */
    abstract protected void error(RuntimeException ex);

    @Override
    public void run() {
        while (isCompleted()) {
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

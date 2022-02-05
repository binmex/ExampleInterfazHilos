package View;

import javax.swing.*;
import java.util.Random;

public class ThreadCount implements Runnable {

    private JTextField count;
    private boolean stop;
    private boolean forward;

    public ThreadCount(JTextField count, boolean forward) {
        this.count = count;
        this.forward = forward;
        stop = false;
    }

    @Override
    public void run() {
        if (forward) {
            for (int cont = Integer.MIN_VALUE; cont <= Integer.MAX_VALUE && !stop; cont++) {
                Integer conts = cont;
                count.setText(conts.toString());
                try {
                    Thread.sleep(new Random().nextLong(501) + 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            for (int cont = Integer.MIN_VALUE; cont <= Integer.MAX_VALUE && !stop; cont--) {
                Integer conts = cont;
                count.setText(conts.toString());
                try {
                    Thread.sleep(new Random().nextLong(501) + 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopThread() {
        stop = true;
    }

}

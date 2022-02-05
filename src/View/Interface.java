package View;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalTime;

public class Interface extends JFrame {
    private JPanel background, timePanel, whitePanel1, whitePanel2, text1Panel, text2Panel, text3Panel, button1Panel,
            button2Panel, button3Panel;
    private JLabel timeLabel, blankLabel1, blankLabel2;
    private JTextField text1, text2, text3;
    private JButton button1, button2, button3;
    private String times;

    public Interface() {
        background = new JPanel();
        whitePanel1 = new JPanel();
        whitePanel2 = new JPanel();
        timePanel = new JPanel();
        text1Panel = new JPanel();
        text2Panel = new JPanel();
        text3Panel = new JPanel();
        button1Panel = new JPanel();
        button2Panel = new JPanel();
        button3Panel = new JPanel();
        blankLabel1 = new JLabel();
        blankLabel2 = new JLabel();
        timeLabel = new JLabel();
        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        ThreadCount thOne = new ThreadCount(text1, false);
        ThreadCount thTwo = new ThreadCount(text2, false);
        ThreadCount thThree = new ThreadCount(text3, false);

        setTitle("Threads Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 300);
        getContentPane().setBackground(Color.WHITE);
        add(workSpace(thOne, thTwo, thThree));
        clock();
        new Thread(thOne).start();
        new Thread(thTwo).start();
		new Thread(thThree).start();
        setVisible(true);
    }

    private JPanel workSpace(ThreadCount thOne, ThreadCount thTwo, ThreadCount thThree) {

        background.setBackground(Color.white);
        background.setLayout(new GridLayout(3, 3));

        whitePanel1.setBackground(getForeground());
        whitePanel1.setBorder(new LineBorder(Color.black));
        whitePanel1.add(blankLabel1);
        background.add(whitePanel1);

        whitePanel2.setBackground(getForeground());
        whitePanel2.setBorder(new LineBorder(Color.black));
        whitePanel2.add(blankLabel2);
        background.add(whitePanel2);

        timePanel.setBackground(getForeground());
        timePanel.setBorder(new LineBorder(Color.black));
        timePanel.add(timeLabel);
        background.add(timePanel);

        text1Panel.setBackground(getForeground());
        text1Panel.setBorder(new LineBorder(Color.black));
        text1Panel.add(text1);
        background.add(text1Panel);

        text2Panel.setBackground(getForeground());
        text2Panel.setBorder(new LineBorder(Color.black));
        text2Panel.add(text2);
        background.add(text2Panel);

        text3Panel.setBackground(getForeground());
        text3Panel.setBorder(new LineBorder(Color.black));
        text3Panel.add(text3);
        background.add(text3Panel);

        button1.setText("Detener");
        button1.addActionListener((e) -> thOne.stopThread());
        button1Panel.setBackground(getForeground());
        button1Panel.setBorder(new LineBorder(Color.black));
        button1Panel.add(button1);
        background.add(button1Panel);

        button2.setText("Detener");
        button2.addActionListener((e) -> thTwo.stopThread());
        button2Panel.setBackground(getForeground());
        button2Panel.setBorder(new LineBorder(Color.black));
        button2Panel.add(button2);
        background.add(button2Panel);

        button3.setText("Detener");
        button3.addActionListener((e) -> thThree.stopThread());
        button3Panel.setBackground(getForeground());
        button3Panel.setBorder(new LineBorder(Color.black));
        button3Panel.add(button3);
        background.add(button3Panel);

        return background;
    }

    private void clock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String localTime;
                while (true) {
                    LocalTime time = LocalTime.now();
                    Integer hour = time.getHour();
                    Integer minutes = time.getMinute();
                    Integer seconds = time.getSecond();
                    localTime = hour.toString() + ":" + minutes.toString() + ":" + seconds.toString();
                    times = localTime;
                    timeLabel.setText(times);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

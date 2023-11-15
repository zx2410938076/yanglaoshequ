package com.yanglao;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class UserInterface extends JFrame {

    private RobotThread robotThread;
    private JButton startBtn;
    private JButton endBtn;
    private JLabel statusLabel;

    public UserInterface() {
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        panel.add(buttonPanel, BorderLayout.NORTH);

        startBtn = new JButton("开始");
        startBtn.addActionListener(e -> {
            setStatus("正在运行");
            startBtn.setEnabled(false);
            endBtn.setEnabled(true);
            robotThread = new RobotThread();
            robotThread.start();
        });
        buttonPanel.add(startBtn);

        endBtn = new JButton("结束");
        endBtn.addActionListener(e -> {
            setStatus("已停止");
            startBtn.setEnabled(true);
            endBtn.setEnabled(false);
            robotThread.stopRobot();
        });
        endBtn.setEnabled(false);
        buttonPanel.add(endBtn);

        statusLabel = new JLabel("等待中", SwingConstants.CENTER);
        statusLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        statusLabel.setForeground(Color.GRAY);
        statusLabel.setPreferredSize(new Dimension(0, 80));
        panel.add(statusLabel, BorderLayout.CENTER);

        setTitle("简单用户界面");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setStatus(String status) {
        statusLabel.setText(status);
    }

    private class RobotThread extends Thread {
        private volatile boolean running;
        private Robot robot;

        public RobotThread() {
            running = true;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            while (running) {
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);

                robot.keyPress(KeyEvent.VK_W);
                robot.keyRelease(KeyEvent.VK_W);
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_E);
                robot.keyRelease(KeyEvent.VK_E);
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_R);
                robot.keyRelease(KeyEvent.VK_R);
            }
        }

        public void stopRobot() {
            running = false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserInterface ui = new UserInterface();
            ui.setVisible(true);
        });
    }
}

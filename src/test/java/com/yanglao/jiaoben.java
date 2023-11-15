package com.yanglao;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Collections;
public class jiaoben {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        while (true){
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
}

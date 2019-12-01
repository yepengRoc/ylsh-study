package com.ylsh.ssy.java8.sty001;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {

    public static void main(String[] args){
        JFrame jFrame = new JFrame("my frame");

        JButton jButton = new JButton("my button");

//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("click button");
//            }
//
//        });

        jButton.addActionListener(actionEvent -> System.out.println("123"));

      jFrame.add(jButton);

        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

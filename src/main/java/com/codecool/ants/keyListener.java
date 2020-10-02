package com.codecool.ants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("type: " + e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("press: " + e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_END:
                System.out.println("ENTER");
                break;
            case KeyEvent.VK_Q:
                System.out.println("QUIT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("release: " + e);
    }
}

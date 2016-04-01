package demo.applets.JumpingBox;
/*
 *
 * Copyright (c) 2007, 2011, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


/**
 * @author Original author unknown
 * @author Alexander Kouznetsov
 */
@SuppressWarnings("serial")
public class JumpingBox extends java.applet.Applet {

    private int mx, my;
    private Dimension size;
    private int onaroll;

    @Override
    public void init() {
        onaroll = 0;
        setSize(500, 500);
        size = getSize();
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                e.consume();
                requestFocus();
                JumpingBox.this.mousePressed(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                repaint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                e.consume();
                if ((e.getX() % 3 == 0) && (e.getY() % 3 == 0)) {
                    repaint();
                }
            }
        });
        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                repaint();
            }
        });
    }

    private void mousePressed(int x, int y) {
        if (mx < x && x < mx + getSize().width / 10 - 1
                && my < y && y < my + getSize().height / 10 - 1) {
            //determine if hit
            if (onaroll > 0) {
                //not first hit
                switch (onaroll % 4) {
                    //play a sound
                    case 0:
                        play(getCodeBase(),
                                "sounds/tiptoe.thru.the.tulips.au");
                        break;
                    case 1:
                        play(getCodeBase(), "sounds/danger.au");
                        break;
                    case 2:
                        play(getCodeBase(), "sounds/adapt-or-die.au");
                        break;
                    case 3:
                        play(getCodeBase(),
                                "sounds/cannot.be.completed.au");
                        break;
                }
                onaroll++;
                if (onaroll > 5) {
                    getAppletContext().
                            showStatus("You're on your way to THE HALL OF FAME:"
                            + onaroll + "Hits!");
                } else {
                    getAppletContext().
                            showStatus("YOU'RE ON A ROLL:" + onaroll + "Hits!");
                }
            } else {
                //first hit
                getAppletContext().showStatus("HIT IT AGAIN! AGAIN!");
                play(getCodeBase(), "sounds/that.hurts.au");
                onaroll = 1;
            }
        } else {
            //miss
            getAppletContext().
                    showStatus("You hit nothing at (" + x + ", " + y
                    + "), exactly");
            play(getCodeBase(), "sounds/thin.bell.au");
            onaroll = 0;
        }
    }

    @Override
    public void update(Graphics g) {
        Dimension newSize = getSize();
        if (size.equals(newSize)) {
            // Erase old box
            g.setColor(getBackground());
            g.drawRect(mx, my, (size.width / 10) - 1,
                    (size.height / 10) - 1);
        } else {
            size = newSize;
            g.clearRect(0, 0, size.width, size.height);
        }
        // Calculate new position
        mx = (int) (Math.random() * 1000) % (size.width - (size.width / 10));
        my = (int) (Math.random() * 1000) % (size.height - (size.height / 10));
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, size.width - 1, size.height - 1);
        g.drawRect(mx, my, (size.width / 10) - 1,
                (size.height / 10) - 1);
    }

    @Override
    public String getAppletInfo() {
        return "Title: JumpingBox\n"
                + "Author: Anonymous";
    }
}

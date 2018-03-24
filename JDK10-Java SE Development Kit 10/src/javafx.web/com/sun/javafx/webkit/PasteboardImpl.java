/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.javafx.webkit;

import com.sun.javafx.tk.Toolkit;
import com.sun.javafx.webkit.UIClientImpl;
import com.sun.webkit.Pasteboard;
import com.sun.webkit.graphics.WCGraphicsManager;
import com.sun.webkit.graphics.WCImageFrame;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javax.imageio.ImageIO;

final class PasteboardImpl implements Pasteboard {

    private final Clipboard clipboard = Clipboard.getSystemClipboard();

    PasteboardImpl() {
    }

    @Override public String getPlainText() {
        return clipboard.getString();
    }

    @Override public String getHtml() {
        return clipboard.getHtml();
    }

    @Override public void writePlainText(String text) {
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }

    @Override public void writeSelection(boolean canSmartCopyOrDelete, String text, String html) {
        ClipboardContent content = new ClipboardContent();
        content.putString(text);
        content.putHtml(html);
        clipboard.setContent(content);
    }

    @Override public void writeImage(WCImageFrame wcImage) {
        Object platformImage = WCGraphicsManager.getGraphicsManager().
                toPlatformImage(wcImage.getFrame());
        Image fxImage = Toolkit.getImageAccessor().fromPlatformImage(platformImage);
        if (fxImage != null) {
            ClipboardContent content = new ClipboardContent();
            content.putImage(fxImage);
            String fileExtension = wcImage.getFrame().getFileExtension();
            try {
                File imageDump = File.createTempFile("jfx", "." + fileExtension);
                imageDump.deleteOnExit();
                ImageIO.write(UIClientImpl.toBufferedImage(fxImage),
                    fileExtension,
                    imageDump);
                content.putFiles(Arrays.asList(imageDump));
            } catch (IOException | SecurityException e) {
                // Nothing specific to be done as of now
            }
            clipboard.setContent(content);
        }
    }

    @Override public void writeUrl(String url, String markup) {
        ClipboardContent content = new ClipboardContent();
        content.putString(url);
        content.putHtml(markup);
        content.putUrl(url);
        clipboard.setContent(content);
    }
}

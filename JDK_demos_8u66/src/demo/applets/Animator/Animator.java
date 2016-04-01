package demo.applets.Animator;
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


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * An applet that plays a sequence of images, as a loop or a one-shot.
 * Can have a soundtrack and/or sound effects tied to individual frames.
 * See the <a href="http://java.sun.com/applets/applets/Animator/">Animator
 * home page</a> for details and updates.
 *
 * @author Herb Jellinek
 */
@SuppressWarnings("serial")
public class Animator extends Applet implements Runnable, MouseListener {

    int appWidth = 0;                // Animator width
    int appHeight = 0;               // Animator height
    Thread engine = null;            // Thread animating the images
    boolean userPause = false;       // True if thread currently paused by user
    boolean loaded = false;          // Can we paint yet?
    boolean error = false;           // Was there an initialization error?
    Animation animation = null;      // Animation this animator contains
    String hrefTarget = null;        // Frame target of reference URL if any
    URL hrefURL = null;              // URL link for information if any
    static final String sourceLocation =
            "http://java.sun.com/applets/applets/Animator/";
    static final String userInstructions = "shift-click for errors, info";
    static final int STARTUP_ID = 0;
    static final int BACKGROUND_ID = 1;
    static final int ANIMATION_ID = 2;

    /**
     * Applet info.
     */
    @Override
    public String getAppletInfo() {
        return "Animator v1.10 (02/05/97), by Herb Jellinek";
    }

    /**
     * Parameter info.
     */
    @Override
    public String[][] getParameterInfo() {
        String[][] info = {
            { "imagesource", "URL", "a directory" },
            { "startup", "URL", "image displayed at start-up" },
            { "backgroundcolor", "int", "background color (24-bit RGB number)" },
            { "background", "URL", "image displayed as background" },
            { "startimage", "int", "index of first image" },
            { "endimage", "int", "index of last image" },
            { "namepattern", "URL", "generates indexed names" },
            { "images", "URLs", "list of image indices" },
            { "href", "URL", "page to visit on mouse-click" },
            { "target", "name", "frame to put that page in" },
            { "pause", "int", "global pause, milliseconds" },
            { "pauses", "ints", "individual pauses, milliseconds" },
            { "repeat", "boolean", "repeat? true or false" },
            { "positions", "coordinates", "path images will follow" },
            { "soundsource", "URL", "audio directory" },
            { "soundtrack", "URL", "background music" },
            { "sounds", "URLs", "list of audio samples" }, };
        return info;
    }

    /**
     * Show a crude "About" box.  Displays credits, errors (if any), and
     * parameter values and documentation.
     */
    void showDescription() {
        DescriptionFrame description = new DescriptionFrame();
        description.tell("\t\t" + getAppletInfo() + "\n");
        description.tell("Updates, documentation at " + sourceLocation + "\n\n");
        description.tell("Document base: " + getDocumentBase() + "\n");
        description.tell("Code base: " + getCodeBase() + "\n\n");

        Object errors[] = animation.tracker.getErrorsAny();
        if (errors != null) {
            description.tell("Applet image errors:\n");
            for (int i = 0; i < errors.length; i++) {
                if (errors[i] instanceof Image) {
                    AnimationFrame frame = animation.frames.get(i);
                    URL url = frame.imageLocation;
                    if (url != null) {
                        description.tell(" " + url + " not loaded\n");
                    }
                }
            }
            description.tell("\n");
        }
        if (animation.frames == null || animation.frames.isEmpty()) {
            description.tell("\n** No images loaded **\n\n");
        }
        description.tell("Applet parameters:\n");
        description.tell(" width = " + getParameter("WIDTH") + "\n");
        description.tell(" height = " + getParameter("HEIGHT") + "\n");
        String params[][] = getParameterInfo();
        for (String[] param : params) {
            String name = param[0];
            description.tell(" " + name + " = " + getParameter(name)
                    + "\t [" + param[2] + "]\n");
        }
        description.setVisible(true);
    }

    /**
     * Local version of getParameter for debugging purposes.
     */
    public String getParam(String key) {
        String result = getParameter(key);
        return result;
    }

    /**
     * Get parameters and parse them
     */
    public void handleParams() {
        try {
            String param = getParam("IMAGESOURCE");
            animation.imageSource = (param == null) ? getDocumentBase()
                    : new URL(getDocumentBase(), param + "/");

            String href = getParam("HREF");
            if (href != null) {
                try {
                    hrefURL = new URL(getDocumentBase(), href);
                } catch (MalformedURLException e) {
                    showParseError(e);
                }
            }

            hrefTarget = getParam("TARGET");
            if (hrefTarget == null) {
                hrefTarget = "_top";
            }
            param = getParam("PAUSE");
            if (param != null) {
                animation.setGlobalPause(Integer.parseInt(param));
            }
            param = getParam("REPEAT");
            animation.repeat = (param == null) ? true
                    : (param.equalsIgnoreCase("yes")
                    || param.equalsIgnoreCase("true"));
            int startImage = 1;
            int endImage = 1;
            param = getParam("ENDIMAGE");
            if (param != null) {
                endImage = Integer.parseInt(param);
                param = getParam("STARTIMAGE");
                if (param != null) {
                    startImage = Integer.parseInt(param);
                }
                param = getParam("NAMEPATTERN");
                animation.prepareImageRange(startImage, endImage, param);
            } else {
                param = getParam("STARTIMAGE");
                if (param != null) {
                    startImage = Integer.parseInt(param);
                    param = getParam("NAMEPATTERN");
                    animation.prepareImageRange(startImage, endImage, param);
                } else {
                    param = getParam("IMAGES");
                    if (param == null) {
                        showStatus("No legal IMAGES, STARTIMAGE, or ENDIMAGE "
                                + "specified.");
                        error = true;
                        return;
                    } else {
                        animation.parseImages(param, getParam("NAMEPATTERN"));
                    }
                }
            }

            param = getParam("BACKGROUND");
            if (param != null) {
                animation.backgroundImageURL = new URL(animation.imageSource,
                        param);
            }
            param = getParam("BACKGROUNDCOLOR");
            if (param != null) {
                animation.backgroundColor = decodeColor(param);
            }
            param = getParam("STARTUP");
            if (param != null) {
                animation.startUpImageURL = new URL(animation.imageSource,
                        param);
            }
            param = getParam("SOUNDSOURCE");
            animation.soundSource = (param == null) ? animation.imageSource
                    : new URL(getDocumentBase(), param + "/");
            param = getParam("SOUNDS");
            if (param != null) {
                animation.parseSounds(param);
            }
            param = getParam("PAUSES");
            if (param != null) {
                animation.parseDurations(param);
            }
            param = getParam("POSITIONS");
            if (param != null) {
                animation.parsePositions(param);
            }
            param = getParam("SOUNDTRACK");
            if (param != null) {
                animation.soundTrackURL = new URL(
                        animation.soundSource, param);
            }
        } catch (MalformedURLException e) {
            showParseError(e);
        } catch (ParseException e) {
            showParseError(e);
        }
    }

    private Color decodeColor(String s) {
        int val = 0;
        try {
            if (s.startsWith("0x")) {
                val = Integer.parseInt(s.substring(2), 16);
            } else if (s.startsWith("#")) {
                val = Integer.parseInt(s.substring(1), 16);
            } else if (s.startsWith("0") && s.length() > 1) {
                val = Integer.parseInt(s.substring(1), 8);
            } else {
                val = Integer.parseInt(s, 10);
            }
            return new Color(val);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Initialize the applet.  Get parameters.
     */
    @Override
    public void init() {
        //animation.tracker = new MediaTracker(this);
        appWidth = getSize().width;
        appHeight = getSize().height;
        animation = new Animation(this);
        handleParams();
        animation.init();
        addMouseListener(this);
        Thread me = Thread.currentThread();
        me.setPriority(Thread.MIN_PRIORITY);
        userPause = false;
    }

    @Override
    public void destroy() {
        removeMouseListener(this);
    }

    void tellLoadingMsg(String file, String fileType) {
        showStatus("Animator: loading " + fileType + " " + file);
    }

    void tellLoadingMsg(URL url, String fileType) {
        tellLoadingMsg(url.toExternalForm(), fileType);
    }

    void clearLoadingMessage() {
        showStatus("");
    }

    void loadError(String fileName, String fileType) {
        String errorMsg = "Animator: Couldn't load " + fileType + " "
                + fileName;
        showStatus(errorMsg);
        System.err.println(errorMsg);
        error = true;
        repaint();
    }

    void loadError(URL badURL, String fileType) {
        loadError(badURL.toExternalForm(), fileType);
    }

    void showParseError(Exception e) {
        String errorMsg = "Animator: Parse error: " + e;
        showStatus(errorMsg);
        System.err.println(errorMsg);
        error = true;
        repaint();
    }

    /**
     * Run the animation. This method is called by class Thread.
     * @see java.lang.Thread
     */
    @Override
    public void run() {
        Thread me = Thread.currentThread();

        if (animation == null) {
            return;
        }
        if (animation.frames == null) {
            return;
        }
        if ((appWidth <= 0) || (appHeight <= 0)) {
            return;
        }

        try {
            animation.startPlaying();

            while (engine == me) {
                // Get current frame and paint it, play its sound
                AnimationFrame thisFrame = animation.frames.get(
                        animation.currentFrame);
                repaint();
                if (thisFrame.sound != null) {
                    thisFrame.sound.play();
                }

                animation.currentFrame++;
                // Check if we are done
                if (animation.currentFrame >= animation.frames.size()) {
                    if (animation.repeat) {
                        animation.currentFrame = 0;
                    } else {
                        return;
                    }
                }

                // Pause for duration or longer if user paused
                try {
                    Thread.sleep(thisFrame.duration);
                    synchronized (this) {
                        while (userPause) {
                            animation.stopPlaying();
                            wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } finally {
            synchronized (this) {
                if (engine == me) {
                    animation.stopPlaying();
                }
            }
        }
    }

    /**
     * No need to clear anything; just paint.
     */
    @Override
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * Paint the current frame
     */
    @Override
    public void paint(Graphics g) {
        if (error || !loaded) {
            if (animation.startUpImage != null) {
                if (animation.tracker.checkID(STARTUP_ID)) {
                    if (animation.backgroundColor != null) {
                        g.setColor(animation.backgroundColor);
                        g.fillRect(0, 0, appWidth, appHeight);
                    }
                    g.drawImage(animation.startUpImage, 0, 0, this);
                }
            } else {
                if ((animation.backgroundImage != null)
                        && (animation.tracker.checkID(BACKGROUND_ID))) {
                    g.drawImage(animation.backgroundImage, 0, 0, this);
                } else {
                    g.clearRect(0, 0, appWidth, appHeight);
                }
            }
        } else {
            animation.paint(g);
        }
    }

    /**
     * Start the applet by forking an animation thread.
     */
    @Override
    public void start() {
        engine = new Thread(this);
        engine.start();
        showStatus(getAppletInfo());
    }

    /**
     * Stop the insanity, um, applet.
     */
    @Override
    public synchronized void stop() {
        engine = null;
        animation.stopPlaying();
        if (userPause) {
            userPause = false;
            notify();
        }
    }

    /**
     * Pause the thread when the user clicks the mouse in the applet.
     * If the thread has stopped (as in a non-repeat performance),
     * restart it.
     */
    @Override
    public synchronized void mousePressed(MouseEvent event) {
        event.consume();
        if ((event.getModifiers() & InputEvent.SHIFT_MASK) != 0) {
            showDescription();
            return;
        } else if (hrefURL != null) {
            // Let mouseClicked handle this.
            return;
        } else if (loaded) {
            userPause = !userPause;
            if (!userPause) {
                animation.startPlaying();
                notifyAll();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if ((hrefURL != null)
                && ((event.getModifiers() & InputEvent.SHIFT_MASK) == 0)) {
            // Note: currently ignored by appletviewer
            getAppletContext().showDocument(hrefURL, hrefTarget);
        }

        showStatus(getAppletInfo() + " -- " + userInstructions);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }

    @Override
    public void mouseEntered(MouseEvent event) {
    }

    @Override
    public void mouseExited(MouseEvent event) {
    }
}


/**
 * A class that represents an animation to be displayed by the applet
 */
class Animation extends Object {

    static final int STARTUP_ID = 0;
    static final int BACKGROUND_ID = 1;
    static final int ANIMATION_ID = 2;
    static final String imageLabel = "image";
    static final String soundLabel = "sound";
    int globalPause = 1300;        // global pause in milliseconds
    List<AnimationFrame> frames = null; // List holding frames of animation
    int currentFrame;              // Index into images for current position
    Image startUpImage = null;     // The startup image if any
    Image backgroundImage = null;  // The background image if any
    AudioClip soundTrack = null;   // The soundtrack for this animation
    Color backgroundColor = null;  // Background color if any
    URL backgroundImageURL = null; // URL of background image if any
    URL startUpImageURL = null;    // URL of startup image if any
    URL soundTrackURL = null;      // URL of soundtrack
    URL imageSource = null;        // Directory or URL for images
    URL soundSource = null;        // Directory or URL for sounds
    boolean repeat;                // Repeat the animation if true
    Image offScrImage;             // Offscreen image
    Graphics offScrGC;             // Offscreen graphics context
    MediaTracker tracker;          // MediaTracker used to load images
    Animator owner;                // Applet that contains this animation

    Animation(Animator container) {
        super();
        owner = container;
    }

    void init() {
        tracker = new MediaTracker(owner);
        currentFrame = 0;
        loadAnimationMedia();
    }

    void setGlobalPause(int pause) {
        globalPause = pause;
    }

    /**
     * Loads the images and sounds involved with this animation
     */
    void loadAnimationMedia() {
        try {
            if (startUpImageURL != null) {
                owner.tellLoadingMsg(startUpImageURL, imageLabel);
                startUpImage = fetchImageAndWait(startUpImageURL, STARTUP_ID);
                if (tracker.isErrorID(STARTUP_ID)) {
                    owner.loadError(startUpImageURL, "start-up image");
                }
                owner.repaint();
            }

            if (backgroundImageURL != null) {
                owner.tellLoadingMsg(backgroundImageURL, imageLabel);
                backgroundImage = fetchImageAndWait(backgroundImageURL,
                        BACKGROUND_ID);
                if (tracker.isErrorID(BACKGROUND_ID)) {
                    owner.loadError(backgroundImageURL,
                            "background image");
                }
                owner.repaint();
            }

            // Fetch the animation frame images
            for (AnimationFrame frame : frames) {
                owner.tellLoadingMsg(frame.imageLocation, imageLabel);
                frame.image = owner.getImage(frame.imageLocation);
                tracker.addImage(frame.image, ANIMATION_ID);
                try {
                    tracker.waitForID(ANIMATION_ID);
                } catch (InterruptedException e) {
                }
            }

            if (soundTrackURL != null && soundTrack == null) {
                owner.tellLoadingMsg(soundTrackURL, imageLabel);
                soundTrack = owner.getAudioClip(soundTrackURL);
                if (soundTrack == null) {
                    owner.loadError(soundTrackURL, "soundtrack");
                    return;
                }
            }

            // Load the sounds into their frames
            for (AnimationFrame frame : frames) {
                if (frame.soundLocation != null) {
                    owner.tellLoadingMsg(frame.soundLocation, soundLabel);
                    try {
                        frame.sound = owner.getAudioClip(frame.soundLocation);
                    } catch (Exception ex) {
                        owner.loadError(frame.soundLocation, soundLabel);
                    }
                }
            }

            owner.clearLoadingMessage();
            offScrImage = owner.createImage(owner.appWidth, owner.appHeight);
            offScrGC = offScrImage.getGraphics();
            offScrGC.setColor(Color.lightGray);
            owner.loaded = true;
        } catch (Exception ex) {
            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    /**
     * Fetch an image and wait for it to come in.  Used to enforce a load
     * order for background and startup images.
     */
    Image fetchImageAndWait(URL imageURL, int trackerClass)
            throws InterruptedException {
        Image image = owner.getImage(imageURL);
        tracker.addImage(image, trackerClass);
        tracker.waitForID(trackerClass);
        return image;
    }

    /**
     * Stuff a range of image names into a List
     * @return a List of image URLs.
     */
    void prepareImageRange(int startImage, int endImage, String pattern)
            throws MalformedURLException {
        frames = new ArrayList<AnimationFrame>(Math.abs(endImage - startImage)
                + 1);
        if (pattern == null) {
            pattern = "T%N.gif";
        }
        if (startImage > endImage) {
            for (int i = startImage; i >= endImage; i--) {
                AnimationFrame frame = new AnimationFrame();
                frames.add(frame);
                frame.duration = globalPause;
                frame.imageLocation = new URL(imageSource,
                        doSubst(pattern, i + ""));
            }
        } else {
            for (int i = startImage; i <= endImage; i++) {
                AnimationFrame frame = new AnimationFrame();
                frames.add(frame);
                frame.duration = globalPause;
                frame.imageLocation = new URL(imageSource,
                        doSubst(pattern, i + ""));
            }
        }
    }

    /**
     * Parse the SOUNDS parameter.  It looks like
     * train.au||hello.au||stop.au, etc., where each item refers to a
     * source image.  Empty items mean that the corresponding image
     * has no associated sound.
     */
    void parseSounds(String attr) throws MalformedURLException {
        int frameIndex = 0;
        int numFrames = frames.size();
        for (int i = 0; (i < attr.length()) && (frameIndex < numFrames);) {
            int next = attr.indexOf('|', i);
            if (next == -1) {
                next = attr.length();
            }
            String sound = attr.substring(i, next);
            if (sound.length() != 0) {
                AnimationFrame frame = frames.get(frameIndex);
                frame.soundLocation = new URL(soundSource, sound);
            }
            i = next + 1;
            frameIndex++;
        }
    }

    /**
     * Parse the IMAGES parameter.  It looks like
     * 1|2|3|4|5, etc., where each number (item) names a source image.
     */
    void parseImages(String attr, String pattern)
            throws MalformedURLException {
        frames = new ArrayList<AnimationFrame>();
        if (pattern == null) {
            pattern = "T%N.gif";
        }
        for (int i = 0; i < attr.length();) {
            int next = attr.indexOf('|', i);
            if (next == -1) {
                next = attr.length();
            }
            String file = attr.substring(i, next);
            AnimationFrame frame = new AnimationFrame();
            frames.add(frame);
            frame.imageLocation = new URL(imageSource, doSubst(pattern, file));
            frame.duration = globalPause;
            i = next + 1;
        }
    }

    /**
     * Parse the PAUSES parameter.  It looks like
     * 1000|500|||750, etc., where each item corresponds to a
     * source image.  Empty items mean that the corresponding image
     * has no special duration, and should use the global one.
     *
     * @return a Hashtable of Integer pauses keyed to Integer
     * frame numbers.
     */
    void parseDurations(String attr) {
        int imageNum = 0;
        int numImages = frames.size();
        for (int i = 0; (i < attr.length()) && (imageNum < numImages);) {
            int next = attr.indexOf('|', i);
            if (next == -1) {
                next = attr.length();
            }
            AnimationFrame aFrame = frames.get(imageNum);
            if (i != next) {
                int duration = Integer.parseInt(attr.substring(i, next));
                aFrame.duration = duration;
            }
            i = next + 1;
            imageNum++;
        }
    }

    /**
     * Parse a String of form xxx@yyy and return a Point.
     */
    Point parsePoint(String s) throws ParseException {
        int atPos = s.indexOf('@');
        if (atPos == -1) {
            throw new ParseException("Illegal position: " + s);
        }
        return new Point(Integer.parseInt(s.substring(0, atPos)),
                Integer.parseInt(s.substring(atPos + 1)));
    }

    /**
     * Parse the POSITIONS parameter.  It looks like
     * 10@30|11@31|||12@20, etc., where each item is an X@Y coordinate
     * corresponding to a source image.  Empty items mean that the
     * corresponding image has the same position as the preceding one.
     *
     * @return a Hashtable of Points keyed to Integer frame numbers.
     */
    void parsePositions(String param)
            throws ParseException {
        int imageNum = 0;
        int numImages = frames.size();
        for (int i = 0; (i < param.length()) && (imageNum < numImages);) {
            int next = param.indexOf('|', i);
            if (next == -1) {
                next = param.length();
            }
            if (i != next) {
                AnimationFrame frame = frames.get(imageNum);
                frame.position = parsePoint(param.substring(i, next));
            }
            i = next + 1;
            imageNum++;
        }
    }

    /**
     * Substitute an integer some number of times in a string, subject to
     * parameter strings embedded in the string.
     * Parameter strings:
     *   %N - substitute the integer as is, with no padding.
     *   %<digit>, for example %5 - substitute the integer left-padded with
     *        zeros to <digits> digits wide.
     *   %% - substitute a '%' here.
     * @param inStr the String to substitute within
     * @param theInt the int to substitute, as a String.
     */
    String doSubst(String inStr, String theInt) {
        String padStr = "0000000000";
        int length = inStr.length();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length;) {
            char ch = inStr.charAt(i);
            if (ch == '%') {
                i++;
                if (i == length) {
                    result.append(ch);
                } else {
                    ch = inStr.charAt(i);
                    if (ch == 'N' || ch == 'n') {
                        // just stick in the number, unmolested
                        result.append(theInt);
                        i++;
                    } else {
                        int pad;
                        if ((pad = Character.digit(ch, 10)) != -1) {
                            // we've got a width value
                            String numStr = theInt;
                            String scr = padStr + numStr;
                            result.append(scr.substring(scr.length() - pad));
                            i++;
                        } else {
                            result.append(ch);
                            i++;
                        }
                    }
                }
            } else {
                result.append(ch);
                i++;
            }
        }
        return result.toString();
    }

    void startPlaying() {
        if (soundTrack != null) {
            soundTrack.loop();
        }
    }

    void stopPlaying() {
        if (soundTrack != null) {
            soundTrack.stop();
        }
    }

    public void paint(Graphics g) {
        int xPos = 0;
        int yPos = 0;
        if ((frames.size() > 0) && tracker.checkID(ANIMATION_ID)
                && (offScrGC != null)) {
            AnimationFrame frame = frames.get(currentFrame);
            Image image = frame.image;
            if (backgroundImage == null) {
                offScrGC.clearRect(0, 0, owner.appWidth, owner.appHeight);
            } else {
                offScrGC.drawImage(backgroundImage, 0, 0, owner);
            }
            if (frame.position != null) {
                xPos = frame.position.x;
                yPos = frame.position.y;
            }
            if (backgroundColor != null) {
                offScrGC.setColor(backgroundColor);
                offScrGC.fillRect(0, 0, owner.appWidth, owner.appHeight);
                offScrGC.drawImage(image, xPos, yPos, backgroundColor, owner);
            } else {
                offScrGC.drawImage(image, xPos, yPos, owner);
            }
            if (offScrImage != null) {
                g.drawImage(offScrImage, 0, 0, owner);
            }
        }
    }
}


/**
 * Instances of this class represent a single frame of an animation
 * There can be an image, sound, and position associated with each frame
 */
class AnimationFrame extends Object {

    static final String imageLabel = "image";
    static final String soundLabel = "sound";
    URL imageLocation = null; // Directory or URL of this frames image
    URL soundLocation = null; // Directory or URL of this frames sound
    int duration;             // Duration time for this frame in milliseconds
    AudioClip sound;          // Sound associated with this frame object
    Image image;              // Image associated with this frame
    Point position;           // Position of this frame
}


/**
 * ParseException: signals a parameter parsing problem.
 */
@SuppressWarnings("serial")
class ParseException extends Exception {

    ParseException(String s) {
        super(s);
    }
}


/**
 * DescriptionFrame: implements a pop-up "About" box.
 */
@SuppressWarnings("serial")
class DescriptionFrame extends Frame implements ActionListener {

    static final int rows = 27;
    static final int cols = 70;
    TextArea info;
    Button cancel;

    DescriptionFrame() {
        super("Animator v1.10");
        add("Center", info = new TextArea(rows, cols));
        info.setEditable(false);
        info.setBackground(Color.white);
        Panel buttons = new Panel();
        add("South", buttons);
        buttons.add(cancel = new Button("Cancel"));
        cancel.addActionListener(this);
        pack();
    }

    @Override
    public void setVisible(boolean b) {
        if (b) {
            info.select(0, 0);
        }
        super.setVisible(b);
    }

    void tell(String s) {
        info.append(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}

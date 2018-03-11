/**
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.awt;

import java.io.IOException;
import java.awt.image.*;
import java.net.URL;
import java.net.URLConnection;
import java.io.File;


/**
 * The splash screen can be created at application startup, before the 
 * Java Virtual Machine (JVM) starts. The splash screen is displayed as an 
 * undecorated window containing an image. You can use GIF, JPEG, and PNG files
 * for the image. Animation (for GIF) and transparency (for GIF, PNG) are
 * supported. The window is positioned at the center of the screen (the
 * position on multi-monitor systems is not specified - it is platform and 
 * implementation dependent).
 * The window is closed automatically as soon as the first window is displayed by
 * Swing/AWT (may be also closed manually using the Java API, see below).
 * <P>
 * There are two ways to show the native splash screen:
 * <P>
 * <UL>
 * <LI>If your application is run from the command line or from a shortcut,
 * use the "-splash:" Java application  launcher option to show a splash screen.
 * <BR>
 * For example: 
 * <PRE>
 * java -splash:filename.gif Test
 * </PRE>
 * <LI>If your application is packaged in a jar file, you can use the
 * "SplashScreen-Image" option in a manifest file to show a splash screen.
 * Place the image in the jar archive and specify the path in the option.
 * The path should not have a leading slash.
 * <BR>
 * For example, in the <code>manifest.mf</code> file:
 * <PRE>
 * Manifest-Version: 1.0
 * Main-Class: Test
 * SplashScreen-Image: filename.gif
 * </PRE>
 * The command line interface has higher precedence over the manifest 
 * setting.
 * </UL>
 * <p>
 * The {@code SplashScreen} class provides the API for controlling the splash 
 * screen. This class may be used to close the splash screen, change the splash
 * screen image, get the image position/size and paint in the splash screen. It
 * cannot be used to create the splash screen; you should use the command line or manifest
 * file option for that.
 * <p>
 * This class cannot be instantiated. Only a single instance of this class
 * can exist, and it may be obtained using the {@link #getSplashScreen()}
 * static method. In case the splash screen has not been created at
 * application startup via the command line or manifest file option,
 * the <code>getSplashScreen</code> method returns <code>null</code>.
 *
 * @author Oleg Semenov
 * @since 1.6
 */
public final class SplashScreen {

    SplashScreen(long ptr) { // non-public constructor
        splashPtr = ptr;
        wasClosed = false;
    }

    /**
     * Returns the {@code SplashScreen} object used for
     * Java startup splash screen control.
     *
     * @throws UnsupportedOperationException if the splash screen feature is not
     *         supported by the current toolkit
     * @throws HeadlessException if {@code GraphicsEnvironment.isHeadless()}
     *         returns true
     * @return the {@link SplashScreen} instance, or <code>null</code> if there is
     *         none or it has already been closed
     */
    public static synchronized SplashScreen getSplashScreen() {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        // SplashScreen class is now a singleton
        if (SplashScreen.theInstance == null) {
            java.security.AccessController.doPrivileged( 
                    new sun.security.action.LoadLibraryAction("splashscreen"));
            long ptr = _getInstance();
            if (ptr == 0) {
                return null;
            }
            if (!_isVisible(ptr)) {
                return null;
            }
            SplashScreen.theInstance = new SplashScreen(ptr);
        }
        return (theInstance.isVisible() ? theInstance : null);
    }

    /**
     * Changes the splash screen image. The new image is loaded from the
     * specified URL; GIF, JPEG and PNG image formats are supported.
     * The method returns after the image has finished loading and the window
     * has been updated.
     * The splash screen window is resized according to the size of
     * the image and is centered on the screen.
     *
     * @param imageURL the non-<code>null</code> URL for the new
     *        splash screen image
     * @throws NullPointerException if {@code imageURL} is <code>null</code>
     * @throws IOException if there was an error while loading the image
     * @throws IllegalStateException if the splash screen has already been
     *         closed
     */
    public void setImageURL(URL imageURL) throws NullPointerException, IOException, IllegalStateException {
        checkVisible();
        URLConnection connection = imageURL.openConnection();
        connection.connect();
        int length = connection.getContentLength();
        java.io.InputStream stream = connection.getInputStream();
        byte[] buf = new byte[length];
        int off = 0;
        while(true) {
            // check for available data
            int available = stream.available();
            if (available <= 0) {
                // no data available... well, let's try reading one byte
                // we'll see what happens then
                available = 1;
            }
            // check for enough room in buffer, realloc if needed
            // the buffer always grows in size 2x minimum
            if (off + available > length) {
                length = off*2;
                if (off + available > length) {
                    length = available+off;
                }
                byte[] oldBuf = buf;
                buf = new byte[length];
                System.arraycopy(oldBuf, 0, buf, 0, off);
            }
            // now read the data
            int result = stream.read(buf, off, available);
            if (result < 0) {
                break;
            }
            off += result;
        }
        synchronized(this) {
            if (!_setImageData(splashPtr, buf)) {
                throw new IOException("Bad image format or i/o error when loading image");
            }
            this.imageURL = imageURL;
        }
    }

    private void checkVisible() {
        if (!isVisible()) {
            throw new IllegalStateException("no splash screen available");
        }
    }
    /**
     * Returns the current splash screen image.
     *
     * @return URL for the current splash screen image file
     * @throws IllegalStateException if the splash screen has already been closed
     */
    public synchronized URL getImageURL() throws IllegalStateException {
        checkVisible();
        if (imageURL == null) {
            try {
                String fileName = _getImageFileName(splashPtr);
                String jarName = _getImageJarName(splashPtr);
                if (fileName != null) {
                    if (jarName != null) {
                        imageURL = new URL("jar:"+(new File(jarName).toURL().toString())+"!/"+fileName);
                    } else {
                        imageURL = new File(fileName).toURL();
                    }
                }
            }
            catch(java.net.MalformedURLException e) {
                // we'll just return null in this case
            }
        }
        return imageURL;
    }

    /**
     * Returns the bounds of the splash screen window as a {@link Rectangle}.
     * This may be useful if, for example, you want to replace the splash
     * screen with your window at the same location.
     * <p>
     * You cannot control the size or position of the splash screen.
     * The splash screen size is adjusted automatically when the image changes.
     *
     * @return a {@code Rectangle} containing the splash screen bounds
     * @throws IllegalStateException if the splash screen has already been closed
     */
    public Rectangle getBounds() throws IllegalStateException {
        checkVisible();
        return _getBounds(splashPtr);
    }

    /**
     * Returns the size of the splash screen window as a {@link Dimension}. 
     * This may be useful if, for example,
     * you want to draw on the splash screen overlay surface.
     * <p>
     * You cannot control the size or position of the splash screen.
     * The splash screen size is adjusted automatically when the image changes.
     *
     * @return a {@link Dimension} object indicating the splash screen size
     * @throws IllegalStateException if the splash screen has already been closed
     */
    public Dimension getSize() throws IllegalStateException {
        return getBounds().getSize();
    }

    /**
     * Creates a graphics context (as a {@link Graphics2D} object) for the splash
     * screen overlay image, which allows you to draw over the splash screen.
     * Note that you do not draw on the main image but on the image that is
     * displayed over the main image using alpha blending. Also note that drawing
     * on the overlay image does not necessarily update the contents of splash
     * screen window. You should call {@code update()} on the
     * <code>SplashScreen</code> when you want the splash screen to be
     * updated immediately.
     *
     * @return graphics context for the splash screen overlay surface
     * @throws IllegalStateException if the splash screen has already been closed
     */
    public Graphics2D createGraphics() throws IllegalStateException {
        if (image==null) {
            Dimension dim = getSize();
            image = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_ARGB);
        }
        return image.createGraphics();
    }

    /**
     * Updates the splash window with current contents of the overlay image.
     *
     * @throws IllegalStateException if the overlay image does not exist; 
     *         for example, if {@code createGraphics} has never been called,
     *         or if the splash screen has already been closed
     */
    public void update() throws IllegalStateException {
        checkVisible();
        if (image == null) {
            throw new IllegalStateException("no overlay image available");
        }
        DataBuffer buf = image.getRaster().getDataBuffer();
        if (!(buf instanceof DataBufferInt)) {
            throw new AssertionError("Overlay image DataBuffer is of invalid type == "+buf.getClass().getName());
        }
        int numBanks = buf.getNumBanks();
        if (numBanks!=1) {
            throw new AssertionError("Invalid number of banks =="+numBanks+" in overlay image DataBuffer");
        }
        if (!(image.getSampleModel() instanceof SinglePixelPackedSampleModel)) {
            throw new AssertionError("Overlay image has invalid sample model == "+image.getSampleModel().getClass().getName());
        }
        SinglePixelPackedSampleModel sm = (SinglePixelPackedSampleModel)image.getSampleModel();
        int scanlineStride = sm.getScanlineStride();
        Rectangle rect = image.getRaster().getBounds();
        int[] data = ((DataBufferInt)buf).getData();
        _update(splashPtr, data, rect.x, rect.y, rect.width, rect.height, scanlineStride);
    }

    /**
     * Hides the splash screen, closes the window, and releases all associated
     * resources.
     *
     * @throws IllegalStateException if the splash screen has already been closed
     */
    public synchronized void close() throws IllegalStateException {
        checkVisible();
        _close(splashPtr);
        image = null;
        wasClosed = true;
        // There should be resetting the theInstance to null to prevent memory 
        // leak. But it brings some more problems with the bug 6382748, so we 
        // let the limited leak to stay.
    }


    /**
     * Determines whether the splash screen is visible. The splash screen may
     * be hidden using {@link #close()}, it is also hidden automatically when
     * the first AWT/Swing window is made visible.
     *
     * @return true if the splash screen is visible (has not been closed yet),
     *         false otherwise
     */
    public boolean isVisible() {
        return !wasClosed && _isVisible(splashPtr);
    }

    private BufferedImage image; // overlay image

    private long splashPtr; // pointer to native Splash structure
    private boolean wasClosed;

    private URL imageURL;

    /**
     * The instance reference for the singleton.
     * (<code>null</code> if no instance exists yet.)
     *
     * @see #getSplashScreen
     * @see #close
     */
    private static SplashScreen theInstance = null;

    private native static void _update(long splashPtr, int[] data, int x, int y, int width, int height, int scanlineStride);
    private native static boolean _isVisible(long splashPtr);
    private native static Rectangle _getBounds(long splashPtr);
    private native static long _getInstance();
    private native static void _close(long splashPtr);
    private native static String _getImageFileName(long splashPtr);
    private native static String _getImageJarName(long SplashPtr);
    private native static boolean _setImageData(long SplashPtr, byte[] data);

};


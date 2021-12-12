/*
 * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.image;

import java.util.Hashtable;
import java.io.InputStream;
import java.io.IOException;
import java.awt.image.*;

public abstract class ImageDecoder {
    InputStreamImageSource source;
    InputStream input;
    Thread feeder;

    protected boolean aborted;
    protected boolean finished;
    ImageConsumerQueue queue;
    ImageDecoder next;

    public ImageDecoder(InputStreamImageSource src, InputStream is) {
        source = src;
        input = is;
        feeder = Thread.currentThread();
    }

    public boolean isConsumer(ImageConsumer ic) {
        return ImageConsumerQueue.isConsumer(queue, ic);
    }

    public void removeConsumer(ImageConsumer ic) {
        queue = ImageConsumerQueue.removeConsumer(queue, ic, false);
        if (!finished && queue == null) {
            abort();
        }
    }

    protected ImageConsumerQueue nextConsumer(ImageConsumerQueue cq) {
        synchronized (source) {
            if (aborted) {
                return null;
            }
            cq = ((cq == null) ? queue : cq.next);
            while (cq != null) {
                if (cq.interested) {
                    return cq;
                }
                cq = cq.next;
            }
        }
        return null;
    }

    protected int setDimensions(int w, int h) {
        ImageConsumerQueue cq = null;
        int count = 0;
        while ((cq = nextConsumer(cq)) != null) {
            cq.consumer.setDimensions(w, h);
            count++;
        }
        return count;
    }

    protected int setProperties(Hashtable<?,?> props) {
        ImageConsumerQueue cq = null;
        int count = 0;
        while ((cq = nextConsumer(cq)) != null) {
            cq.consumer.setProperties(props);
            count++;
        }
        return count;
    }

    protected int setColorModel(ColorModel model) {
        ImageConsumerQueue cq = null;
        int count = 0;
        while ((cq = nextConsumer(cq)) != null) {
            cq.consumer.setColorModel(model);
            count++;
        }
        return count;
    }

    protected int setHints(int hints) {
        ImageConsumerQueue cq = null;
        int count = 0;
        while ((cq = nextConsumer(cq)) != null) {
            cq.consumer.setHints(hints);
            count++;
        }
        return count;
    }

    protected void headerComplete() {
        feeder.setPriority(ImageFetcher.LOW_PRIORITY);
    }

    protected int setPixels(int x, int y, int w, int h, ColorModel model,
                            byte[] pix, int off, int scansize) {
        source.latchConsumers(this);
        ImageConsumerQueue cq = null;
        int count = 0;
        while ((cq = nextConsumer(cq)) != null) {
            cq.consumer.setPixels(x, y, w, h, model, pix, off, scansize);
            count++;
        }
        return count;
    }

    protected int setPixels(int x, int y, int w, int h, ColorModel model,
                            int[] pix, int off, int scansize) {
        source.latchConsumers(this);
        ImageConsumerQueue cq = null;
        int count = 0;
        while ((cq = nextConsumer(cq)) != null) {
            cq.consumer.setPixels(x, y, w, h, model, pix, off, scansize);
            count++;
        }
        return count;
    }

    protected int imageComplete(int status, boolean done) {
        source.latchConsumers(this);
        if (done) {
            finished = true;
            source.doneDecoding(this);
        }
        ImageConsumerQueue cq = null;
        int count = 0;
        while ((cq = nextConsumer(cq)) != null) {
            cq.consumer.imageComplete(status);
            count++;
        }
        return count;
    }

    public abstract void produceImage() throws IOException,
                                               ImageFormatException;

    @SuppressWarnings("removal")
    public void abort() {
        aborted = true;
        source.doneDecoding(this);
        close();
        java.security.AccessController.doPrivileged(
            new java.security.PrivilegedAction<Object>() {
            public Object run() {
                feeder.interrupt();
                return null;
            }
        });
    }

    public synchronized void close() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
            }
        }
    }
}

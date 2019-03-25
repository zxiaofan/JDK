/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.awt.X11;

public abstract class XErrorHandler {

    /*
     * Called under AWT lock
     */
    public abstract int handleError(long display, XErrorEvent err);

    /*
     * Forwards all the errors to saved error handler (which was
     * set before XToolkit had been initialized).
     */
    public static class XBaseErrorHandler extends XErrorHandler {
        @Override
        public int handleError(long display, XErrorEvent err) {
            return XErrorHandlerUtil.SAVED_XERROR_HANDLER(display, err);
        }
    }

    /*
     * Instead of validating window id, we simply call XGetWindowProperty,
     * but temporary install this function as the error handler to ignore
     * BadWindow error.
     */
    public static class IgnoreBadWindowHandler extends XBaseErrorHandler {
        @Override
        public int handleError(long display, XErrorEvent err) {
            if (err.get_error_code() == XConstants.BadWindow) {
                return 0;
            }
            return super.handleError(display, err);
        }
        // Shared instance
        private static IgnoreBadWindowHandler theInstance = new IgnoreBadWindowHandler();
        public static IgnoreBadWindowHandler getInstance() {
            return theInstance;
        }
    }

    public static class VerifyChangePropertyHandler extends XBaseErrorHandler {
        @Override
        public int handleError(long display, XErrorEvent err) {
            if (err.get_request_code() == XProtocolConstants.X_ChangeProperty) {
                return 0;
            }
            return super.handleError(display, err);
        }
        // Shared instance
        private static VerifyChangePropertyHandler theInstance = new VerifyChangePropertyHandler();
        public static VerifyChangePropertyHandler getInstance() {
            return theInstance;
        }
    }
}

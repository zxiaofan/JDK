/*
 * Copyright (c) 2010, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.fxml;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller initialization interface.
 * <p>
 * <em>NOTE</em> This interface has been superseded by automatic injection of
 * <code>location</code> and <code>resources</code> properties into the
 * controller. {@link FXMLLoader} will now automatically call any suitably
 * annotated no-arg <code>initialize()</code> method defined by the controller.
 * It is recommended that the injection approach be used whenever possible.
 * @since JavaFX 2.0
 */
public interface Initializable {
    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    public void initialize(URL location, ResourceBundle resources);
}

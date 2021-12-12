/*
 * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth.callback;

/**
 * <p> Underlying security services instantiate and pass a
 * {@code TextInputCallback} to the {@code handle}
 * method of a {@code CallbackHandler} to retrieve generic text
 * information.
 *
 * @since 1.4
 * @see javax.security.auth.callback.CallbackHandler
 */
public class TextInputCallback implements Callback, java.io.Serializable {

    @java.io.Serial
    private static final long serialVersionUID = -8064222478852811804L;

    /**
     * @serial
     * @since 1.4
     */
    private String prompt;
    /**
     * @serial
     * @since 1.4
     */
    private String defaultText;
    /**
     * @serial
     * @since 1.4
     */
    private String inputText;

    /**
     * Construct a {@code TextInputCallback} with a prompt.
     *
     * @param prompt the prompt used to request the information.
     *
     * @exception IllegalArgumentException if {@code prompt} is null
     *                  or if {@code prompt} has a length of 0.
     */
    public TextInputCallback(String prompt) {
        if (prompt == null || prompt.isEmpty())
            throw new IllegalArgumentException();
        this.prompt = prompt;
    }

    /**
     * Construct a {@code TextInputCallback} with a prompt
     * and default input value.
     *
     * @param prompt the prompt used to request the information.
     *
     * @param defaultText the text to be used as the default text displayed
     *                  with the prompt.
     *
     * @exception IllegalArgumentException if {@code prompt} is null,
     *                  if {@code prompt} has a length of 0,
     *                  if {@code defaultText} is null
     *                  or if {@code defaultText} has a length of 0.
     */
    public TextInputCallback(String prompt, String defaultText) {
        if (prompt == null || prompt.isEmpty() ||
            defaultText == null || defaultText.isEmpty())
            throw new IllegalArgumentException();

        this.prompt = prompt;
        this.defaultText = defaultText;
    }

    /**
     * Get the prompt.
     *
     * @return the prompt.
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Get the default text.
     *
     * @return the default text, or null if this {@code TextInputCallback}
     *          was not instantiated with {@code defaultText}.
     */
    public String getDefaultText() {
        return defaultText;
    }

    /**
     * Set the retrieved text.
     *
     * @param text the retrieved text, which may be null.
     *
     * @see #getText
     */
    public void setText(String text) {
        this.inputText = text;
    }

    /**
     * Get the retrieved text.
     *
     * @return the retrieved text, which may be null.
     *
     * @see #setText
     */
    public String getText() {
        return inputText;
    }
}

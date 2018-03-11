package java.lang.annotation;

/**
 * Thrown to indicate that a program has attempted to access an element of
 * an annotation type that was added to the annotation type definition after
 * the annotation was compiled (or serialized).  This exception will not be
 * thrown if the new element has a default value.
 *
 * @author  Josh Bloch
 * @since 1.5
 */
public class IncompleteAnnotationException extends RuntimeException {
    private Class annotationType;
    private String elementName;


    /**
     * Constructs an IncompleteAnnotationException to indicate that
     * the named element was missing from the specified annotation type.
     *
     * @param annotationType the Class object for the annotation type
     * @param elementName the name of the missing element
     */
    public IncompleteAnnotationException(
            Class<? extends Annotation> annotationType,
            String elementName) {
        super(annotationType.getName() + " missing element " + elementName);

        this.annotationType = annotationType;
        this.elementName = elementName;
    }

    /**
     * Returns the Class object for the annotation type with the
     * missing element.
     *
     * @return the Class object for the annotation type with the
     *     missing element
     */
    public Class<? extends Annotation> annotationType() {
        return annotationType;
    }

    /**
     * Returns the name of the missing element.
     *
     * @return the name of the missing element
     */
    public String elementName() {
        return elementName;
    }
}

package org.transparent.glaze.annotations;

import org.transparent.glaze.misc.Implicit;

import java.lang.annotation.*;

/**
 * This annotation marks a constructor or method as being an extension method for the target class.
 * <p>
 * The target class is specified using the <code>value</code> annotation property,
 * or can be inferred if the extension method is that of an instance method.
 * <p>
 * This annotation doesn't extend the target class, but instead, it replaces the original
 * method call with a call to the annotated method during compile-time.
 * <p>
 * Unfortunately, a side-effect of this call replacement is that the processor will
 * have to access private or protected members of the target via reflection.
 *
 * @author  Maow
 * @version %I%
 * @see     Self
 * @since   1.0.0
 */
@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Extension {
    /**
     * Specifies the target class for this extension method.
     * <p>
     * If this property is set to target {@link Implicit}
     * and the method includes an instance parameter, the target class will be inferred.
     *
     * @return the target class of this extension method
     */
    Class<?> value() default Implicit.class;
}

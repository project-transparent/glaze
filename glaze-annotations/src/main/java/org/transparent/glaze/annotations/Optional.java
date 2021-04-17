package org.transparent.glaze.annotations;

import java.lang.annotation.*;

/**
 * Marks a parameter as being optional.
 * <p>
 * When a parameter is optional, it can be omitted from a method call.
 * If this annotation is used on a method or constructor,
 * all parameters are optional.
 *
 * @author  Maow
 * @version %I%
 * @since   1.0.0
 */
@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface Optional {
}
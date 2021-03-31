package org.transparent.glaze.annotations;

import org.transparent.glaze.misc.Implicit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation marks an instance parameter.
 * <p>
 * Said parameter is the instance this method has been called on,
 * of which static extension methods don't have, and must explicitly omit.
 * <p>
 * When an instance parameter is found and the extension method targets {@link Implicit},
 * the target class will be inferred from the type of the parameter.
 *
 * @author  Maow
 * @version %I%
 * @see     Extension
 * @since   1.0.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.SOURCE)
public @interface Self {
}

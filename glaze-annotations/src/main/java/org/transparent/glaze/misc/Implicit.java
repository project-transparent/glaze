package org.transparent.glaze.misc;

import org.transparent.glaze.annotations.Extension;
import org.transparent.glaze.annotations.Self;

/**
 * This uninstantiable class serves as a placeholder for
 * {@link Extension}'s <code>value</code> property.
 * When found, <code>Extension</code>'s target class will be inferred.
 *
 * @author  Maow
 * @version %I%
 * @see     Self
 * @since   1.0.0
 */
public final class Implicit {
    /**
     * @throws UnsupportedOperationException when instantiated
     */
    private Implicit() {
        throw new UnsupportedOperationException();
    }
}

package org.transparent.glaze.core.optional;

import com.sun.tools.javac.tree.JCTree.*;
import org.transparent.eureka.util.Annotations;
import org.transparent.glaze.annotations.Optional;
import org.transparent.lucent.transform.LucentBaseValidator;

public class OptionalValidator extends LucentBaseValidator {
    @Override
    public boolean validateParameter(JCVariableDecl parameter) {
        return Annotations.isAnnotated(parameter, Optional.class);
    }

    @Override
    public boolean validateMethod(JCMethodDecl method) {
        return Annotations.isAnnotated(method, Optional.class);
    }
}

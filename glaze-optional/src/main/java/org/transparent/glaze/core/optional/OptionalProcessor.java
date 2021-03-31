package org.transparent.glaze.core.optional;

import org.transparent.glaze.annotations.Optional;
import org.transparent.lucent.processor.LucentProcessor;
import org.transparent.lucent.transform.LucentTranslator;
import org.transparent.lucent.util.TypeKind;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.Set;

public class OptionalProcessor extends LucentProcessor {
    @Override
    public LucentTranslator getTranslator() {
        return translator(OptionalTranslator::new);
    }

    @Override
    public Set<TypeKind> getSupportedTypeKinds() {
        return Collections.singleton(TypeKind.CLASS);
    }

    @Override
    public Class<? extends Annotation> getSupportedAnnotation() {
        return Optional.class;
    }
}
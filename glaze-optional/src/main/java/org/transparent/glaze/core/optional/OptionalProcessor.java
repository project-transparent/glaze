package org.transparent.glaze.core.optional;

import org.transparent.glaze.annotations.Optional;
import org.transparent.lucent.processor.LucentProcessor;
import org.transparent.lucent.transform.LucentTranslator;

import java.lang.annotation.Annotation;

public class OptionalProcessor extends LucentProcessor {
    @Override
    public LucentTranslator getTranslator() {
        return translator(OptionalTranslator::new);
    }

    @Override
    public Class<? extends Annotation> getSupportedAnnotation() {
        return Optional.class;
    }
}
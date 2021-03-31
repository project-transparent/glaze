package org.transparent.glaze.core.optional;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.*;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Names;
import org.transparent.interlucent.transform.EurekaTranslator;
import org.transparent.lucent.transform.LucentValidator;

import javax.lang.model.element.Element;

public class OptionalTranslator extends EurekaTranslator {
    public OptionalTranslator(Names names, TreeMaker factory) {
        super(names, factory);
    }

    @Override
    protected LucentValidator getValidator() {
        return new OptionalValidator();
    }

    @Override
    public void translate(JCTree tree, Element element) {
        tree.accept(this);
    }

    @Override
    public void visitMethodDef(JCMethodDecl method) {
        super.visitMethodDef(method);
        // If method valid -> instantly accept param
        if (validator.validateMethod(method)) {
            method.params.forEach(
                    param -> acceptParam(method, param));
            return;
        }
        // If method not valid -> check param validity
        method.params.forEach(
                param -> visitParam(method, param));
    }

    private void visitParam(JCMethodDecl method,
                            JCVariableDecl param) {
        if (validator.validateParameter(param))
            acceptParam(method, param);
    }

    private void acceptParam(JCMethodDecl method,
                             JCVariableDecl param) {

    }
}
package org.transparent.glaze.core.optional;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Names;
import org.transparent.interlucent.transform.EurekaTranslator;

import javax.lang.model.element.Element;

public class OptionalTranslator extends EurekaTranslator {
    public OptionalTranslator(Names names, TreeMaker factory) {
        super(names, factory);
    }

    @Override
    public void translate(JCTree tree, Element element) {

    }
}

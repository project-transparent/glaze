package org.transparent.glaze.core.optional;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.TypeTag;
import com.sun.tools.javac.tree.JCTree.*;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Names;
import org.transparent.interlucent.transform.EurekaTranslator;
import org.transparent.lucent.transform.LucentValidator;

import java.util.LinkedHashSet;
import java.util.Set;

public class OptionalTranslator extends EurekaTranslator {
    public OptionalTranslator(Names names, TreeMaker factory,
                              LucentValidator validator) {
        super(names, factory, validator);
    }

    @Override
    public void visitClassDef(JCClassDecl clazz) {
        super.visitClassDef(clazz);
        result = inject(clazz)
                .methods()
                .addAll(this::overloads)
                .tree();
    }

    private Set<JCMethodDecl> overloads(JCMethodDecl method) {
        final Set<JCMethodDecl> overloads = new LinkedHashSet<>();
        for (int i = 1; i <= optional(method); i++)
            overloads.add(overload(method, i));
        return overloads;
    }

    private int optional(JCMethodDecl method) {
        return (int) method.params
                .stream()
                .filter(validator::validateParameter)
                .count();
    }

    private JCMethodDecl overload(JCMethodDecl method, int skip) {
        final String name = method.name.toString();
        final JCVariableDecl[] params =
                params(method.params, skip);
        return method()
                .mods(method.mods.flags)
                .type(method.restype)
                .name(name)
                .params(params)
                .body(body(method.restype.type, name, params, skip))
                .build();
    }

    private JCVariableDecl[] params(List<JCVariableDecl> params, int skip) {
        List<JCVariableDecl> newParams = List.nil();
        for (final JCVariableDecl param : params) {
            // if param is optional and total skipped is not skip amount then skip
            if (validator.validateParameter(param) && skip != 0) {
                skip--;
                continue;
            }
            newParams = newParams.append(param);
        }
        return newParams.toArray(new JCVariableDecl[0]);
    }

    private JCBlock body(Type type, String name, JCVariableDecl[] params, int skip) {
        List<JCExpression> newParams = List.nil();
        for (JCVariableDecl param : params) {
            if (validator.validateParameter(param) && skip != 0) {
                skip--;
                newParams = newParams.append(literal());
                continue;
            }
            newParams = newParams.append(id(param));
        }
        // TODO: Improve Eureka to reduce boilerplate shown below.
        // TODO: Add constructor logic.
        final JCMethodInvocation invoke = factory.maker()
                .Apply(List.nil(), id(name), newParams);
        final JCStatement statement = (type.hasTag(TypeTag.VOID))
                ? factory.maker().Exec(invoke)
                : factory.maker().Return(invoke);
        return factory.maker().Block(0L, List.of(statement));
    }
}
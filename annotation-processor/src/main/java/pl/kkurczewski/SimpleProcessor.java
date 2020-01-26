package pl.kkurczewski;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnv) {
        if (set.isEmpty()) {
            return false;
        }
        String classes = roundEnv
                .getRootElements()
                .stream()
                .map(Element::getSimpleName)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println("You have classes with @Deprecated annotation:\n" + classes);
        return false;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Deprecated.class.getCanonicalName());
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_11;
    }
}
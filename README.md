### Minimal setup for annotation processor

#### Processor module

* Class implementing `javax.annotation.processing.Processor`
* File with name of processor:

```
# content of resources/META-INF/services/javax.annotation.processing.Processor
pl.kkurczewski.SimpleProcessor
```

#### Implementors module

```
dependencies {
    annotationProcessor project(":annotation-processor") # or external gradle dependency
}
```

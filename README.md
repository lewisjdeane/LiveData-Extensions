# LiveData Extensions

An Android library allowing you to write beautifully concise and clean code for complex LiveData transformations.

```kotlin
/** Instead of `Transformations.map` */
liveData.map { data -> /* Do something with data */ }

/** Instead of `Transformations.switchMap` */
liveData.switchMap { data -> /* Do something with data */ }

/** Instead of nested maps and switchMaps. */
Transformations.map(liveA, liveB, liveC, liveD, liveE) { a, b, c, d, e ->
    // method(a, b, c, d, e)
}

/** Instead of nested maps and switchMaps. */
liveA.mapWith(liveB, liveC, liveD, liveE) { a, b, c, d, e ->
    // method(a, b, c, d, e)
}

```

# Config

In your top-level build.gradle make sure you have jitpack listed as a repository:

```groovy
allprojects {
    repositories {
        maven {
            url 'https://jitpack.io'
        }
        ...
    }
}
```

In your app-specific build.gradle:

```groovy
implementation 'com.github.lewisjdeane:LiveData-Extensions:1.0'
```

# Usage

This library allows you write complex LiveData manipulations in a clean and concise way:

```kotlin
Transformations.map(liveA, liveB, liveC, liveD, liveE) { a, b, c, d, e ->
    // method(a, b, c, d, e)
}

// or equally,

liveA.mapWith(liveB, liveC, liveD, liveE) { a, b, c, d, e ->
    // method(a, b, c, d, e)
}
```

instead of the horrible mess of nesting you'd need to write before:

```kotlin
Transformations.switchMap(liveA) { a ->
    Transformations.switchMap(liveB) { b ->
        Transformations.switchMap(liveC) { c ->
            Transformations.switchMap(liveD) { d ->
                Transformations.map(liveE) { e ->
                    // method(a, b, c, d, e)
                }
            }
        }
    }
}
```

## Single `map`/`switchMap`

With this library you can write clearer map and switchMap statements:

```kotlin
liveData.map { data -> /* Do something with data */ }
liveData.switchMap { data -> /* Do something with data */ }
```

Which is the equivalent to:

```kotlin
Transformations.map(liveData) { data ->
    // Do something with data
}

Transformations.switchMap(liveData) { data ->
    // Do something with data
}
```

## Combining Multiple LiveDatas

Previously you may have had a huge nested block of maps and switchMaps to unbox all the LiveDatas and then perform an operation on them before boxing them back up. This library flattens out this nesting to something far more readable.

### Extending `Transformations.map`

With this library, Transformations.map now takes up to 6 parameters so you can now write:

```kotlin
Transformations.map(liveA, liveB, liveC, liveD, liveE, liveF) { a, b, c, d, e, f ->
    // method(a, b, c, d, e, f)
}
```

Instead of the far less-readable:

```kotlin
Transformations.switchMap(liveA) { a ->
    Transformations.switchMap(liveB) { b ->
        Transformations.switchMap(liveC) { c ->
            Transformations.switchMap(liveD) { d ->
                Transformations.switchMap(liveE) { e ->
                    Transformations.map(liveF) { f ->
                        // method(a, b, c, d, e, f)
                    }
                }
            }
        }
    }
}
```

### New `mapWith` Extension Function

If you prefer to use an extension function on a LiveData directly then if you want to combine more than 1 LiveData then you can use the new `mapWith` method, this is equivalent to the extended `Transformations.map`.

With `mapWith`, you'd write:

```kotlin
liveA.mapWith(liveB, liveC, liveD, liveE, liveF) { a, b, c, d, e, f ->
    // method(a, b, c, d, e, f)
}
```

Instead of the far less-readable:

```kotlin
Transformations.switchMap(liveA) { a ->
    Transformations.switchMap(liveB) { b ->
        Transformations.switchMap(liveC) { c ->
            Transformations.switchMap(liveD) { d ->
                Transformations.switchMap(liveE) { e ->
                    Transformations.map(liveF) { f ->
                        // method(a, b, c, d, e, f)
                    }
                }
            }
        }
    }
}
```

# License

Apache License 2.0

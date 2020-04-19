# LiveData Extensions

# Config

In your top-level build.gradle make sure you have jitpack listed as a repository:

```
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

```
implementation 'com.github.lewisjdeane:VariableHintEditText:-SNAPSHOT'
```

# License

Apache License 2.0

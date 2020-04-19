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
implementation 'com.github.lewisjdeane:LiveData-Extensions:1.0'
```

# License

Apache License 2.0

# vaadin 8 binder

Vaadin experiment with vaadin 8 binder

# Why this repository exists

Vaadin 8.2 exteds Binder paradigm which has existed since 8.0.

Vaadin 8.2 rc1 Binder doesn't seem to work as expected what comes to buffered edits using bean level validator.

# Experiment setup

This experiment is prepared using vaadin-gradle plugin

https://github.com/johndevs/gradle-vaadin-plugin/wiki/Getting-Started-on-the-console

# Project setup

Create project directory

Write build.gradle to root of project directory

```
// Tell Gradle to add Vaadin support

plugins {
  id 'com.devsoap.plugin.vaadin' version '1.2.6'
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

// added vaadin pre release repository
// see maven config at: https://vaadin.com/framework/releases

repositories {
    maven { url "https://maven.vaadin.com/vaadin-prereleases" }
}

vaadin {
    version '8.2.0.rc1'
}
```

Create skeleton

- gradle vaadinCreateProject

Run skeleton

- gradle vaadinRun

If there's problems try

- gradle vaadinRun --debug

# IDE

Code has been written using IDEA community edition. Support for Gradle is good and Java code editing works nicely.

# Limitations

It seems that gradle-addon picks theme from latest version of vaadin (currently 8.1.7) and not one that I've defined (8.2.0.rc1). 

# JVM tools in Linux

In case you need JVM tools in Linux to experiment by yourself

Install SDKMAN

$ curl -s https://get.sdkman.io | bash

Open a new terminal and install tool

$ sdk install gradle 4.3.1


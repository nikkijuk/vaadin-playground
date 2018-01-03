# vaadin 8 guice

Vaadin experiment with vaadin 8 guice add on

This experminent contains previous experimennt with gradle-addon

# Why this repository exists

Vaadin 8.2.0 has CDI support "almost" natively for Spring and CDI

Vaadin 8.2.0 Guice support comes with vaadin guice addon

https://vaadin.com/directory/component/guice-vaadin-integration

# Experiment setup

This experiment is prepared using vaadin-gradle plugin

https://github.com/johndevs/gradle-vaadin-plugin/wiki/Getting-Started-on-the-console

# Project setup

Create project directory

Write build.gradle to root of project directory

```
// Tell Gradle to add Vaadin support

plugins {
  id 'com.devsoap.plugin.vaadin' version '1.3.0'
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

// added vaadin pre release repository
// see maven config at: https://vaadin.com/framework/releases

repositories {
    maven { url "https://maven.vaadin.com/vaadin-prereleases" }
}

dependencies {
  compile group: 'com.vaadin', name: 'guice-vaadin', version:'2.0.1-vaadin8'
}

vaadin {
    version '8.2.0'
}
```

Create skeleton

- gradle vaadinCreateProject

Run skeleton

- gradle vaadinRun

If there's problems try

- gradle vaadinRun --debug

# Adding guice



# IDE

Code has been written using IDEA community edition. Support for Gradle is good and Java code editing works nicely.

# JVM tools in Linux

In case you need JVM tools in Linux to experiment by yourself

Install SDKMAN

$ curl -s https://get.sdkman.io | bash

Open a new terminal and install tool

$ sdk install gradle 4.4.1


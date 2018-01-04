# vaadin 8 guice

Vaadin experiment with vaadin 8 guice add on

This experiment contains previous experimennt with gradle-addon

# Why this repository exists

Vaadin 8.2.0 has DI support "almost" natively for Spring and CDI

Vaadin 8.2.0 Guice support comes with vaadin guice addon

Vaadin Guice support is fork of Spring support addon, but has possibly taken it's own direction

https://vaadin.com/directory/component/guice-vaadin-integration

# Experiment setup

This experiment is prepared using vaadin-gradle plugin

https://github.com/johndevs/gradle-vaadin-plugin/wiki/Getting-Started-on-the-console

There was some problems getting things to compile, and I needed to revert to Gradle 4.3.1 from 4.4.1 

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

Guice add on needs to be added as dependency to build.gradle 

```
dependencies {
  compile group: 'com.vaadin', name: 'guice-vaadin', version:'2.0.1-vaadin8'
}
```

# Vaadin Guice docs 

Documentation is scarce. Best source to get overview could be video tutorial from developer of addon

https://www.youtube.com/watch?v=cFpHlEhJBZY

Otherwise I'd advice to get to the sources

https://github.com/berndhopp/guice

# Vaadin Guice sample apps

There's two samples which aren't really too deeply documented, but you can play with them

https://github.com/berndhopp/guiceexample

https://github.com/berndhopp/guice-example

# IDE

Code has been written using IDEA community edition. Support for Gradle is good and Java code editing works nicely.

# JVM tools in Linux

In case you need JVM tools in Linux to experiment by yourself

Install SDKMAN

$ curl -s https://get.sdkman.io | bash

Open a new terminal and install tool

$ sdk install gradle 4.4.1


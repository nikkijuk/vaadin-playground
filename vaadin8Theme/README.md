# vaadin 8 theme

Vaadin experiment with customized vaadin theme

This experiment contains previous experiments with gradle-addon and guice-addon 

# Why this repository exists

Vaadin 8.2.0 has wonderful Valo theme, which can be extended and customized

Vaadin valo theme is customized by extending it or overwriting property values

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

// set source level
sourceCompatibility = 1.8
targetCompatibility = 1.8

// define vaadin version
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

# creating custom theme

Create new theme using gradle-addon

- gradle vaadinCreateTheme --name=kaamos

# compiling changes

Vaadin gradle-addon manages to hot deploy at least some changes

When necessary clean project, compile theme by hand and test.

- gradle clean

- gradle vaadinThemeCompile

- gradle vaadinRun

Remember to refresh browser caches or your css might not be loaded 

# Vaadin theming documents

https://demo.vaadin.com/valo-theme/

https://vaadin.com/framework/theming

https://vaadin.com/docs/v8/framework/themes/themes-overview.html

# IDE

Code has been written using IDEA community edition. Support for Gradle is good and Java code editing works nicely.

# JVM tools in Linux

In case you need JVM tools in Linux to experiment by yourself

Install SDKMAN

$ curl -s https://get.sdkman.io | bash

Open a new terminal and install tool

$ sdk install gradle 4.4.1


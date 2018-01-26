# vaadin 8 crud

Vaadin experiment with crud ui addon

This experiment contains previous experiments with gradle-addon, guice-addon and customized theme

# Why this experiment exists

Vaadin is fancy framework for writing ui's, but it's also very well suitable for framework and platform development

This experiment tries single addon, which tries to create out of box solution for simple crud ui's

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

# Vaadin theming

Vaadin 8.3.0 has wonderful Valo theme, which can be extended and customized

Vaadin valo theme is customized by extending it or overwriting property values

# creating custom theme

Create new theme using gradle-addon

- gradle vaadinCreateTheme --name=kaamos

Remember to give theme meaningful name, here 'Kaamos'

Theme will be created to directory

- src/main/resources/VAADIN/themes

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

# Vaadin side menus

Vaadin has menubar included, but side menu needs some extra work

Implementation classes in this project
 
- SidebarMenu
- SidebarLayout

Here's one example how to do it by yourself

https://github.com/alejandro-du/community-answers/tree/master/side-menu

Please read here how it's done

https://vaadin.com/blog/community-answer-implementing-a-side-menu-with-view-navigation

Other example can be found here

https://github.com/rolfsmeds/devday17-themedemo

Rolfs example needs some explanations - and they are here

https://www.youtube.com/watch?v=InHvMyZtAVY

# Crud ui's

https://github.com/alejandro-du/crudui

https://vaadin.com/directory/component/crud-ui-add-on

# IDE

Code has been written using IDEA community edition. Support for Gradle is good and Java code editing works nicely.

# JVM tools in Linux

In case you need JVM tools in Linux to experiment by yourself

Install SDKMAN

$ curl -s https://get.sdkman.io | bash

Open a new terminal and install tool

$ sdk install gradle 4.4.1


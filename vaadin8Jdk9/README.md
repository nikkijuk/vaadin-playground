vaadinJdk9
==============

Simple project, just to see if there's general errors 

- Configured local environment to use jdk 9 & maven 3.5.2
- Started IDEA CE
- Created skeleton with vaadin-archetype-application
- Defined jdk 9 & maven 3.5.2 to be used
- Changed in Pom.xml jetty to one which supports fully jdk 9
- Changed source code and target class to be in java 9 format

More info in accompanying links

https://vaadin.com/docs/v8/framework/getting-started/getting-started-idea.html

https://vaadin.com/docs/v8/framework/getting-started/getting-started-archetypes.html

Test it
========

Compile with "mvn install".

run with "mvn jetty:run" and open http://localhost:8080/ .

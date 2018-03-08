vaadin8jdk9
==============

Simple project, just to see if there's general errors 

- Configured local environment to use jdk 9 & maven 3.5.2
- Started IDEA CE
- Created skeleton with vaadin-archetype-application
- Defined jdk 9 & maven 3.5.2 to be used 
- Changed in Pom.xml maven war plugin to version 3.2.0
- Changed in Pom.xml jetty to one which supports fully jdk 9 (includes asm 6.0)
- Changed source code and target class to be in java 9 format

More info in accompanying links

https://vaadin.com/docs/v8/framework/getting-started/getting-started-idea.html

https://vaadin.com/docs/v8/framework/getting-started/getting-started-archetypes.html

My results
========

No problems found - Vaadin 8 & Java 9 seem to work as expected

Test it yourself
========

Compile with "mvn install".

run with "mvn jetty:run" and open http://localhost:8080/ .

Further info
========

Jetty & java 9 & Asm 6.0 

https://github.com/eclipse/jetty.project/issues/1213

Asm

http://asm.ow2.org/
com.jukkanikki.vaadin8Liberty
==============

Template for a simple Vaadin application that requires a Servlet 3.1 container to run.

Creation
========

Project has been created using liberty-archetype-webapp version 2.1.2

mvn archetype:generate \
    -DarchetypeGroupId=net.wasdev.wlp.maven \
    -DarchetypeArtifactId=liberty-archetype-webapp \
    -DarchetypeVersion=2.1.2 \
    -DgroupId=com.jukkanikki \
    -DartifactId=vaadin8liberty \
    -Dversion=1.0-SNAPSHOT

See more from here

More of available arhetypes here

https://github.com/WASdev/ci.maven

Using Open Liberty
========

Open Liberty? Get to know it here ..

https://openliberty.io/

Test generated skeleton
========

mvn clean install

mvn liberty:run-server

http://localhost:9080/vaadin8liberty/

Add vaadin servlet
========

Add dependencies to pom.xml

Add plugins and plugin configuration to pom.xml

Add simple UI class and accompanying servlet definition

Remove unnecessary index.html, web.xml and HelloServlet.java

Adjust or remove EndpointIt test case

Run server
========

So far only tested from command line

you can take example from this repository and run it

running happens exactly like testing of generated skeleton


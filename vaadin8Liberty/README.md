com.jukkanikki.vaadin8Liberty
==============

Template for a simple Vaadin application that only requires a Servlet 3.0 container to run.

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

mvn install

Run server
========

You can run app many ways:

* mvn package && java -jar target/example-vaadin-swarm.jar
* mvn wildfly-swarm:run
* In your IDE run the `org.wildfly.swarm.Swarm` class

Open app
========

Since WildFly Swarm apps tend to support one deployment per executable, it
automatically adds a `jboss-web.xml` to the deployment if it doesn't already
exist.  This is used to bind the deployment to the root of the web-server,
instead of using the `.war`'s own name as the application context.

    http://localhost:8080/

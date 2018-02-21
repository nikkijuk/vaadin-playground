com.jukkanikki.vaadin8swarm
==============

Template for a simple Vaadin application that only requires a Servlet 3.0 container to run.

Creation
========

Project has been created using vaadin app archetype version 8.3.0

https://mvnrepository.com/artifact/com.vaadin/vaadin-archetype-application/8.3.0

More of available arhetypes here

https://vaadin.com/docs/v8/framework/getting-started/getting-started-archetypes.html

Migration to wildfly swarm
========

Swarm? Get to know it here ..

http://wildfly-swarm.io/

Example of using wildfly swarm with vaadin 7 is here

https://github.com/wildfly-swarm/wildfly-swarm-examples

Swarm Maven Plugin
========

This project is a traditional web app project, with maven packaging
of `war` in the `pom.xml`

    <packaging>war</packaging>

The project adds a `<plugin>` to configure `wildfly-swarm-plugin` to
create the runnable `.jar`.

    <plugin>
      <groupId>org.wildfly.swarm</groupId>
      <artifactId>wildfly-swarm-plugin</artifactId>
      <version>${version.wildfly-swarm}</version>
      <executions>
        <execution>
          <goals>
            <goal>package</goal>
          </goals>
        </execution>
      </executions>
    </plugin>

We let the plugin determine which dependencies we need, so we don't add any ourselves.

See pom.xml for details.

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

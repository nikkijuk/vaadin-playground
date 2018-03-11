com.jukkanikki.vaadin8cdi
==============

Template for a simple Vaadin application that requires a Servlet 3.0 container & CDI (so: at least micro profile) to run.

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

and docs

http://docs.wildfly-swarm.io/2018.3.0/

Example of using wildfly swarm with vaadin 7 is here

https://github.com/wildfly-swarm/wildfly-swarm-examples

For this example all components were actualized to newest versions

- Wildfly Swarm 2018.3.0
- CDI 2.0
- Vaadin 8.3.1
- Vaadin CDI addon 3.0

Vaadin CDI helpers don't yet work due to incompatibility issue

https://vaadin.com/directory/component/cdi-helpers

https://github.com/mstahv/cdi-helpers/issues/9

Swarm Maven Plugin
========

This project is a traditional web app project, with maven packaging of `war` in the `pom.xml`

    <packaging>war</packaging>

But it has also speciality - swarm plugin

https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/content/v/1.0.0.Alpha6/maven-plugin.html

The project adds a `<plugin>` to configure `wildfly-swarm-plugin` to create the runnable `.jar`.

Maven swarm plugin is run at package phase

    <!-- https://mvnrepository.com/artifact/org.wildfly.swarm/wildfly-swarm-plugin -->
    <plugin>
        <groupId>org.wildfly.swarm</groupId>
        <artifactId>wildfly-swarm-plugin</artifactId>
        <version>${version.wildfly-swarm}</version>
        <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>package</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <properties>
                <swarm.bind.address>127.0.0.1</swarm.bind.address>
                <!-- see: new port -->
                <swarm.http.port>9191</swarm.http.port>
            </properties>
        </configuration>
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

    http://localhost:9191/

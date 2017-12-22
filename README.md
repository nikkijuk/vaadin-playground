# vaadin-playground

Vaadin experiments 

# Why this repository exists

Vaadin is interesting technology with long history of providing tools to develop efficiently backoffice UI's 

As JVM ecosystem and Vaadin itself evolve I've find it interesting to experiment current state of art and share my experiments

# Vaadin evolves

Vaadin was one of technologies which helped to break dominance of JSP/JSTL + Struts/Tiles + Xml configuration 

Vaadin 6, 7 & 8 use GWT to isolate Java developer from browser differences - which are coming smaller

Vaadin itself has come to release 8, which has simplified backend api in comparison to Vaadin 7

Vaadin 10 is in horizon and will integrate to JS world differently, dropping efficiently dependency to GWT

# JVM based web development evolves

Larger standard JVM stack still needs to be challanged

Java itself just works, but Kotlin might be effective clean alternative?
Maven, err.., is complicated, still better than ANT, but could Gradle help here?
JPA and Hibernate are used widely, but could we remove complicated abstractions with JOOQ, QueryDSL, ..?
Spring? CDI? Guice? Is there room for Dagger?

# Learning is your everyday job

It never stops. There's no single superior solution. Set your goals and see what fits to you.

# In case you need JVM tools in Linux to experiments by yourself

Install SDKMAN

$ curl -s https://get.sdkman.io | bash

Open a new terminal and install tool

$ sdk install gradle 4.3.1


## Create the webapp without web.xml using servlet 3
1. Make sure pom is updated for servlet 3 jar
2. Create the class which extend from AbstractDispatcherServletInitializer, this is equivelent to web.xml
3. Use maven jetty plug-in (org.eclipse.jetty) 9.3 version to read the ServletInitializer
4.Use maven-war-plugin plugin with attribute failOnMissingWebXml to false to ensure it does not look for web.xml # springBeerCore

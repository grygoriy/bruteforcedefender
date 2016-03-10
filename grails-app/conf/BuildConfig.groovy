grails.project.work.dir = "target"
grails.project.target.level = 1.7
grails.project.source.level = 1.7

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'
    legacyResolve false

    repositories {
        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        runtime 'com.google.guava:guava:11.0.1'
        build 'commons-io:commons-io:2.1'
        runtime 'commons-io:commons-io:2.4'
        compile 'org.springframework:spring-aop:3.2.9.RELEASE' 
        compile 'org.springframework:spring-expression:3.2.9.RELEASE'
    }

    plugins {
        build(':release:3.1.2', ':rest-client-builder:2.1.1') {
            export = false
        }
        compile ":spring-security-core:2.0-RC4"
        compile ':cache:1.1.8'
        compile ":cache-ehcache:1.0.5"
    }
}

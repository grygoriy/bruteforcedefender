grails.project.work.dir = "target"
grails.project.target.level = 1.7
grails.project.source.level = 1.7

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        runtime 'com.google.guava:guava:18.0'
        build 'org.springframework:spring-aop:3.2.9.RELEASE'
        build 'org.springframework:spring-expression:3.2.9.RELEASE'
        build 'net.sf.ehcache:ehcache:2.8.4'
    }

    plugins {
        build ':release:3.0.1', ':rest-client-builder:1.0.3', {
            export = false
        }

        compile ":rest:0.8"
        compile ":spring-security-core:2.0-RC3"
    }
}

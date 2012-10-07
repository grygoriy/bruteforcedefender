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
        runtime 'com.google.guava:guava:11.0.1'
    }

    plugins {
        build(':release:2.0.4', ':rest-client-builder:1.0.2') {
            export = false
        }
        compile ":spring-security-core:1.2.7.3"
    }
}

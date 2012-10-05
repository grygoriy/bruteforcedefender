Brute-force Deffender Plugin Info
================================

##Desciption
Grails plugin enables blocking user account after few attampts with incorect credentials. Preventing brute-force attacks

## Instalation
### install from prebuilded
- goto https://github.com/grygoriy/bruteforcedeffender/downloads
- dowload latest version
- use `grails install-plugin <path to file>`

### build from sources
- clone repo `git clone https://github.com/grygoriy/bruteforcedeffender.git`
- build plugin `grails package-pllugin`
- you should see plugin zip file in plugin directory
- use `grails install-plugin <path to file>`

## Configuration
Add to your `config.groovy` next lines
```groovy
bruteforcedeffender {
    time = 5
    allowedNumberOfAttempts = 3
}
```

## Logging
To enable login add next lines in your `config.groovy`
```groovy
environments {
    development {
    debug "grails.app.services.com.grygoriy.bruteforcedeffender"
}
```

Grygoriy Mykhalyuno
www.grygoriy.com
email@grygoriy.com
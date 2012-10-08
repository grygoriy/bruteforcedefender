Brute-force Defender Plugin Info
================================

##Desciption
Plugin adds functionality of blocking user account after a number of falied login, thus countering brute-force attacks. Plugin is working on top of configured Spring Security Core plugin with its UserDetails.

## Instalation
### dependencies
- plugi
### install from prebuilded
- goto https://github.com/grygoriy/bruteforcedefender/downloads
- dowload latest version
- use `grails install-plugin <path to file>`

### build from sources
- clone repo `git clone https://github.com/grygoriy/bruteforcedefender.git`
- build plugin `grails package-pllugin`
- you should see plugin zip file in plugin directory
- use `grails install-plugin <path to file>`

## Configuration
Add to your `Config.groovy` next lines
```groovy
bruteforcedefender {
    time = 5
    allowedNumberOfAttempts = 3
}
```

## Logging
To enable login add next lines in your `Config.groovy`
```groovy
log4j = {
    ....
    environments {
        development {
            debug 'grails.app.services.com.grygoriy.bruteforcedefender'
        }
    }
}
```

Grygoriy Mykhalyuno

www.grygoriy.com

email@grygoriy.com

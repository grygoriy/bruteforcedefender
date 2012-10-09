Brute-force Defender Plugin Info
================================

##Description
Plugin adds functionality of blocking user account after a configured number of failed login, thus countering brute-force attacks. Plugin is working on top of configured Spring Security Core plugin with its UserDetails.

## Installation
### Dependencies
- plugin depents on Spring Security Core plugin
### install from pre-compliled
- go to https://github.com/grygoriy/bruteforcedefender/downloads
- download latest version
- use `grails install-plugin <path to file>`

### build from sources
- clone repo `git clone https://github.com/grygoriy/bruteforcedefender.git`
- build plugin `grails package-plugin`
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

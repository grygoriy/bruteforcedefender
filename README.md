Brute-force Defender Plugin Info
================================

##Description
Plugin adds functionality of blocking user account after a configured number of failed login, thus countering brute-force attacks. Plugin is working on top of configured Spring Security Core plugin with its UserDetails.

## Installation
### Dependencies
- plugin depents on Spring Security Core plugin

### From grails plugin reposity
* follow instrations here grails.org/plugin/bruteforce-defender
* add `compile ":bruteforce-defender:1.0"` to `BuildConfig.groovy`

### Install from pre-compliled
- go to https://github.com/grygoriy/bruteforcedefender/downloads
- download latest version
- use `grails install-plugin <path to file>`

### Build from sources
- clone repo `git clone https://github.com/grygoriy/bruteforcedefender.git`
- build plugin `grails package-plugin`
- you should see plugin zip file in plugin directory
- use `grails install-plugin <path to file>`

## Configuration
Add to your `Config.groovy` next lines
```groovy
grails.plugins.springsecurity.useSecurityEventListener = true

bruteforcedefender {
    time = 5
    allowedNumberOfAttempts = 3
}

```


## Logging
To enable logging, add next lines in your `Config.groovy`
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
## Demo application
Here is demo application that you can just run and look how it is working.
https://github.com/grygoriy/s2-brutforce-example
Thanks to @stokito


Grygoriy Mykhalyuno

www.grygoriy.com

email@grygoriy.com


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/grygoriy/bruteforcedefender/trend.png)](https://bitdeli.com/free "Bitdeli Badge")


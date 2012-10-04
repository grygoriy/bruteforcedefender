## Instalation
- goto https://github.com/grygoriy/bruteforcedeffender/downloads
- dowload latest version
- use grails install-plugin <path to file>

## Configuration
Add to your config.groovy next lines
bruteforcedeffender {
    time = 5
    allowedNumberOfAttempts = 3
}

## Logging
to enable login add next lines in your config.groovy
    environments {
        development {
    debug "grails.app.services.com.grygoriy.bruteforcedeffender"
    }


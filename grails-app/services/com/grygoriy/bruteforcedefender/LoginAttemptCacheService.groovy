package com.grygoriy.bruteforcedefender

import java.util.concurrent.TimeUnit

import javax.annotation.PostConstruct

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache

class LoginAttemptCacheService {

    def grailsApplication

    private LoadingCache<String, Integer> attempts

    private Integer allowedNumberOfAttempts

    @PostConstruct
    void init() {
        allowedNumberOfAttempts = grailsApplication.config.bruteforcedefender.allowedNumberOfAttempts
        Integer time = grailsApplication.config.bruteforcedefender.time

        log.debug "account block configured for $time minutes"
        log.debug "allowed number of attempts configured for $allowedNumberOfAttempts minutes"

        attempts = CacheBuilder.newBuilder()
                                    .expireAfterWrite(time, TimeUnit.MINUTES)
                                    .build({0} as CacheLoader)
    }

    /**
     * Triggers on each unsuccessful login attempt and increases number of attempts in local accumulator
     * @param login - username which is trying to login
     * @return
     */
    def failLogin(String login) {
        int numberOfAttempts = attempts.get(login)
        log.debug "fail login $login previous number for attempts $numberOfAttempts"
        numberOfAttempts++

        if (numberOfAttempts >= allowedNumberOfAttempts) {
            blockUser(login)
            attempts.invalidate(login)
        } else {
            attempts.put(login, numberOfAttempts)
        }
    }

    /**
     * Triggers on each successful login attempt and resets number of attempts in local accumulator
     * @param login - username which is login
     */
    def loginSuccess(String login) {
        log.debug "successfull login for $login. Number of failder attempts is setted to "
        attempts.invalidate(login)
    }

    /**
     * Disable user account so it would not able to login
     * @param login - username that has to be disabled
     */
    private void blockUser(String login) {

        log.debug "blocking user: $login"
        def user = loadUser(login)
        if (user) {
            def conf = SpringSecurityUtils.securityConfig
            String accountLockedPropertyName = conf.userLookup.accountLockedPropertyName
            user."$accountLockedPropertyName" = true
            user.save(flush: true)
        }
    }

    private loadUser(String login) {
        def conf = SpringSecurityUtils.securityConfig
        String userClassName = conf.userLookup.userDomainClassName
        def dc = grailsApplication.getDomainClass(userClassName)
        if (!dc) {
            throw new RuntimeException("The specified user domain class '$userClassName' is not a domain class")
        }
        Class<?> User = dc.clazz
        User.findWhere((conf.userLookup.usernamePropertyName): login)
    }
}

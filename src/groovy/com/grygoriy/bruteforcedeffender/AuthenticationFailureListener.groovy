package com.grygoriy.bruteforcedeffender

import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent

/**
 * @author Grygoriy Mykhalyunyo
 */
class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    LoginAttemptCacheService loginAttemptCacheService

    void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        loginAttemptCacheService.failLogin(e.authentication.name)
    }
}

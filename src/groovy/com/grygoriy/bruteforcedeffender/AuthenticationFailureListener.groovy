package com.grygoriy.bruteforcedeffender

import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent
import org.springframework.context.ApplicationListener

/**
 * User: Grygoriy Mykhalyunyo
 * Date: 7/14/12
 * Time: 6:15 PM
 */
class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    LoginAttemptCacheService loginAttemptCacheService

    @Override
    void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        loginAttemptCacheService.failLogin(e.authentication.name)
    }
}

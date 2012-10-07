package com.grygoriy.bruteforcedefender

import org.springframework.context.ApplicationListener
import org.springframework.security.authentication.event.AuthenticationSuccessEvent

/**
 * @author Grygoriy Mykhalyunyo
 */
class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    LoginAttemptCacheService loginAttemptCacheService

    void onApplicationEvent(AuthenticationSuccessEvent e) {
        loginAttemptCacheService.loginSuccess(e.authentication.name)
    }
}

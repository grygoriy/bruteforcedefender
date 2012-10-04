package com.grygoriy.bruteforcedeffender

import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import org.springframework.context.ApplicationListener

/**
 * User: Grygoriy Mykhalyunyo
 * Date: 7/14/12
 * Time: 6:16 PM
 */
class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent>{

    LoginAttemptCacheService loginAttemptCacheService

    @Override
    void onApplicationEvent(AuthenticationSuccessEvent e) {
        loginAttemptCacheService.loginSuccess(e.authentication.name)
    }
}

import com.grygoriy.bruteforcedefender.AuthenticationFailureListener
import com.grygoriy.bruteforcedefender.AuthenticationSuccessEventListener

class BruteforceDefenderGrailsPlugin {
    def version = "1.0"
    def grailsVersion = "2.0 > *"
    def title = "Bruteforce Defender Plugin"
    def author = "Grygoriy Mykhalyuno"
    def authorEmail = "email@grygoriy.com"
    def description = 'Plugin adds functionality of blocking user account after a configured number of failed login, thus countering brute-force attacks. Plugin is working on top of configured Spring Security Core plugin with its UserDetails.'
    def documentation = "https://github.com/grygoriy/bruteforcedefender"

    def license = "APACHE"
    def issueManagement = [ system: "github", url: "https://github.com/grygoriy/bruteforcedefender" ]
    def scm = [ url: "https://github.com/grygoriy/bruteforcedefender" ]

    def doWithSpring = {
        authenticationFailureListener(AuthenticationFailureListener) {
            loginAttemptCacheService = ref('loginAttemptCacheService')
        }

        authenticationSuccessEventListener(AuthenticationSuccessEventListener) {
            loginAttemptCacheService = ref('loginAttemptCacheService')
        }
    }
}

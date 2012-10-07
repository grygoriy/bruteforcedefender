import com.grygoriy.bruteforcedefender.AuthenticationFailureListener
import com.grygoriy.bruteforcedefender.AuthenticationSuccessEventListener

class BruteforceDefenderGrailsPlugin {
    def version = "1.0"
    def grailsVersion = "2.0 > *"
    def title = "Bruteforce Defender Plugin"
    def author = "Grygoriy Mykhalyuno"
    def authorEmail = "email@grygoriy.com"
    def description = 'Enables blocking user account after few attampts with incorect credentials. Preventing brute-force attacks'
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

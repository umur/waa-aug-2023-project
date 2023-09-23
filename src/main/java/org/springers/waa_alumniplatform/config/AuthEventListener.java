package org.springers.waa_alumniplatform.config;

import org.springers.waa_alumniplatform.exception.BadRequestException;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthEventListener {
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        System.out.println("********************* Success ********************** " + success.getAuthentication().getName());
        // ...
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failures) {
        System.out.println("********************* failed ********************** " + failures.getAuthentication().getName());
//       throw new LockedException("U scrwed");
        // ...
    }
}

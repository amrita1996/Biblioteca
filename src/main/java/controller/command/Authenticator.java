package controller.command;

import java.util.Optional;
import java.util.Set;

public class Authenticator {
    private final Set<Credential> credentials;
    private Optional<User> sessionUser;

    public Authenticator(Set<Credential> credentials) {
        this.credentials = credentials;
        sessionUser = Optional.empty();
    }

    public Optional<User> authenticate(Credential given) {
        for (Credential credential: credentials ) {
            if (credential.equals(given)) {
                sessionUser = Optional.of(credential.getUser());
                return sessionUser;
            }

        }
        return Optional.empty();
    }

    public Optional<User> getSessionUser() {
        return sessionUser;
    }
}

package controller.command;

import java.util.Optional;
import java.util.Set;

public class Authenticator {
    private final Set<Credential> credentials;
    private User sessionUser;

    public Authenticator(Set<Credential> credentials) {
        this.credentials = credentials;
    }

    public Optional<User> authenticate(Credential given) {
        for (Credential credential: credentials ) {
            if (credential.equals(given)) {
                sessionUser = credential.getUser();
                return Optional.of(sessionUser);
            }

        }
        return Optional.empty();
    }
}

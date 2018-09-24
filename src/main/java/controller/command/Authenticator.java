package controller.command;

import java.util.Optional;
import java.util.Set;

public class Authenticator {
    private final Set<Credential> credentials;

    public Authenticator(Set<Credential> credentials) {
        this.credentials = credentials;
    }

    public Optional<User> authenticate(Credential given) {
        for (Credential credential: credentials ) {
            if (credential.equals(given)) {
                return Optional.of(credential.getUser());
            }

        }
        return Optional.empty();
    }
}

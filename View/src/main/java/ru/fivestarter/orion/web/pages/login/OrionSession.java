package ru.fivestarter.orion.web.pages.login;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 22.02.13
 */
public class OrionSession extends AuthenticatedWebSession {

    public static final String UID = "UID";
    public static final String USER_NAME = "USER_NAME";
    /**
     * Construct.
     *
     * @param request The current request object
     */
    public OrionSession(Request request) {
        super(request);
    }

    @Override
    public boolean authenticate(String username, String password) {
        if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
            setAttribute(UID, username.hashCode() + password.hashCode());
            setAttribute(USER_NAME, username);
            return true;
        }
        return false;
    }

    @Override
    public Roles getRoles() {
        if (getAttribute(UID) instanceof Integer) {
            return new Roles("ADMIN, USER");
        }
        return new Roles("USER");
    }
}

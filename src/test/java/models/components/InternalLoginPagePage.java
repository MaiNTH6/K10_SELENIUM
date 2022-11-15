package models.components;

public class InternalLoginPagePage extends LoginPage {

    @Override
    protected String usernameLocator() {
        return "InternalLoginPage | usernameLocator";
    }


    @Override
    protected String passwordLocator() {
        return "InternalLoginPage | passwordLocator";
    }


    @Override
    protected String loginLocator() {
        return "InternalLoginPage | loginLocator";
    }
}

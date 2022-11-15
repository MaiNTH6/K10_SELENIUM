package models.components;

public class ExternalLoginPagePage extends LoginPage {

    @Override
    protected String usernameLocator() {
        return "ExternalLoginPage | usernameLocator";
    }


    @Override
    protected String passwordLocator() {
        return "ExternalLoginPage | passwordLocator";
    }


    @Override
    protected String loginLocator() {
        return "ExternalLoginPage | loginLocator";
    }
}

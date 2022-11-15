package models.components;

import java.lang.reflect.Constructor;

public class GenericTypeExploring {
    public <T extends LoginPage> void login(Class<T> loginPageClass) {
        Class<?>[] parameters = new Class[]{};
        try {
            Constructor<T> constructor = loginPageClass.getConstructor();
            T loginPageObj = constructor.newInstance();
            loginPageObj.login();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GenericTypeExploring().login(InternalLoginPagePage.class);
        new GenericTypeExploring().login(ExternalLoginPagePage.class);

    }
}

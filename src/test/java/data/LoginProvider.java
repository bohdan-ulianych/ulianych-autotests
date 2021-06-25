package data;

import org.testng.annotations.DataProvider;
import utils.PropertyHelper;

public class LoginProvider {


    public static final String VALID_LOGIN = PropertyHelper.getConf().validLogin();
    public static final String VALID_PASSWORD = PropertyHelper.getConf().validPassword();
    public static final String INVALID_LOGIN = PropertyHelper.getConf().invalidLogin();
    public static final String INVALID_PASSWORD = PropertyHelper.getConf().invalidPassword();

    @DataProvider(name = "Test with incorrect data.")
    public static Object[][] manageDataProvider() {
        return new Object[][]{
                {VALID_LOGIN, INVALID_PASSWORD},
                {INVALID_LOGIN, VALID_PASSWORD}
        };
    }
}
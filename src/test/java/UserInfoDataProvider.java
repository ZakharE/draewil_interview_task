import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

import static net.andreinc.mockneat.unit.types.Ints.ints;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;
import static net.andreinc.mockneat.unit.user.Passwords.passwords;

public class UserInfoDataProvider {
    @DataProvider
    public Object[][] userInfo() {
        return new Object[][]{
                {new UserInfo(names().first().get(),
                        names().last().get(),
                        ints().range(1000, 50000).get().toString(),
                        emails().get(),
                        passwords().get(),
                        getInviteCode())}
        };


    }

    private String getInviteCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }
}

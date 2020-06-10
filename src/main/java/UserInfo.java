import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserInfo {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String inviteCode;
}

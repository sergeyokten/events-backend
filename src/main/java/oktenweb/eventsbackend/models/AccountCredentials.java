package oktenweb.eventsbackend.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountCredentials {
    private String username;
    private String password;
}

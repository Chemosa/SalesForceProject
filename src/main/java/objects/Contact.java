package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private String contactLastName;
    private String accountName;
    private String salutation;
    private String contactPhone;
    private String mailingStreet;
    private String contactEmail;
}

package pl.wsb.fitnesstracker.mail.internal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mail")
@Getter
@Setter
class MailProperties {

    /**
     * Email address that the email should be sent from.
     */
    private String from;

}

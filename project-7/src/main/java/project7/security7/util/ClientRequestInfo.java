package project7.security7.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author Habib
 * @on 11/10/21 - 11:16 AM
 */
@Data
@NoArgsConstructor
@Component
@SessionScope // bu annotation sayinde altındaki attributelar her hangi anda ulaşabilirim
public class ClientRequestInfo {
    private String  clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
}

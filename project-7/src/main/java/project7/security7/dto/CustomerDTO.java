package project7.security7.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Habib
 * @on 10/14/21 - 1:00 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @ApiModelProperty(hidden = true)
    private long id ;
    @ApiModelProperty(example = "habib")
    private String firstName;
    @ApiModelProperty(example = "dabba")
    private String lastName;
    @ApiModelProperty(example = "1111111")
    private long ssid;
    @ApiModelProperty(example = "habibdabbag@gmail.com")
    private String email;
}

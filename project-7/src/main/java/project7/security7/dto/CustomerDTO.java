package project7.security7.dto;

import io.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Habib
 * @on 10/14/21 - 1:00 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @ApiModelProperty(hidden = true)
    private long id;
    @ApiModelProperty(example = "habib")
    @NotBlank(message = "name is mandatory")
    private String firstName;
    @ApiModelProperty(example = "dabba")
    @NotBlank(message = "last Name is mandatory")
    private String lastName;
    @ApiModelProperty(example = "1111111")
    @NotNull(message = "SSID is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private long ssid;
    @ApiModelProperty(example = "habibdabbag@gmail.com")
    @NotBlank(message = "email is mandatory")
    @Email(message = "email is mandatory")
    private String email;
}

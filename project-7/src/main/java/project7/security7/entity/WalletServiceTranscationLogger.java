package project7.security7.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project7.security7.enumuration.Currency;
import project7.security7.enumuration.TranscationType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Habib
 * @on 11/14/21 - 11:02 PM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletServiceTranscationLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private double afterBalance;
    private double beforBalance;
    private double transcationAmount;
    @Enumerated(EnumType.STRING)
    private Currency transcationCurrency;
    private LocalDate transcatiınDataTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
    @Enumerated(EnumType.STRING)
    private TranscationType transcationType;

}

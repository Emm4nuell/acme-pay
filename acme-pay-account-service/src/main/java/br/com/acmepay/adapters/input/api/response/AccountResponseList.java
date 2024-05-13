package br.com.acmepay.adapters.input.api.response;

import br.com.acmepay.application.domain.models.AccountDomain;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseList {
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private LocalDateTime created_at;

    public static List<AccountResponseList> accountList(List<AccountDomain> list){
        List<AccountResponseList> accounts = list.stream().map(x ->
                AccountResponseList.builder()
                        .number(x.getNumber())
                        .agency(x.getAgency())
                        .balance(x.getBalance())
                        .close(x.getClose())
                        .created_at(x.getCreated_at())
                        .build()).collect(Collectors.toList());

        return accounts;
    }
}

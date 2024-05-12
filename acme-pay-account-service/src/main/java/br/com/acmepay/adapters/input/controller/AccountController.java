package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.IAccountResourceAPI;
import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class AccountController implements IAccountResourceAPI {

    private final ICreateAccountUseCase createAccountUseCase;

    @Override
    public AccountResponse create(AccountRequest request) {
        var domain = AccountDomain.builder()
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .close(false)
                .agency(request.getAgency())
                .number(request.getNumber())
                .balance(request.getBalance())
                .build();
        createAccountUseCase.execute(domain);
        return AccountResponse.builder()
                .message("account created!")
                .build();
    }
}

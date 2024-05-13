package br.com.acmepay.application.ports.in;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.application.domain.models.AccountDomain;

import java.util.List;

public interface ICreateAccountUseCase {
    void execute(AccountDomain domain);
    List<AccountDomain> findAll();
}

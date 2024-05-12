package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.models.AccountDomain;

public interface ICreateAccount {

    void execute(AccountDomain accountDomain);
}

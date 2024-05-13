package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.models.AccountDomain;

import java.util.List;

public interface ICreateAccount {

    void execute(AccountDomain accountDomain);
    List<AccountDomain> findAll();
}

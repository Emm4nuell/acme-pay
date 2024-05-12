package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/accounts")
public interface IAccountResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AccountResponse create(@RequestBody AccountRequest request);
}

package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.adapters.input.api.response.AccountResponseList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/accounts")
public interface IAccountResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AccountResponse create(@RequestBody AccountRequest request);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("list")
    List<AccountResponseList> findAll();
}

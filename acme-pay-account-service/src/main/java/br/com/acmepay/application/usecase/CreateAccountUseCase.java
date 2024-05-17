package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UseCase
@AllArgsConstructor
public class CreateAccountUseCase implements ICreateAccountUseCase {

    private final ICreateAccount createAccount;

    @Override
    public void execute(AccountDomain domain) {
        int somasegundodigito = 0;
        int somaprimeirodigito = 0;
        int primeirodigito = 10;
        int segundodigito = 11;

        if (domain.getDocument() != null && domain.getDocument().length() == 11) {
            String[] arr = domain.getDocument().split("");
            for (int x = 0; x < arr.length; x++) {
                if (x < 9) {
                    somaprimeirodigito += Integer.parseInt(arr[x]) * primeirodigito;
                    primeirodigito--;
                }
                if(x < 10){
                    somasegundodigito += Integer.parseInt(arr[x]) * segundodigito;
                    segundodigito--;
                }
            }

            int primeirodigitoverificador = 11 - (somaprimeirodigito % 11);
            int segundodigitoverificador = 11 - (segundodigito % 11);

            boolean blprimeiro = primeirodigitoverificador == Integer.parseInt(arr[9])
                    || primeirodigitoverificador >= 10 && 0 == Integer.parseInt(arr[9]);
            boolean blsegundo = segundodigitoverificador == Integer.parseInt(arr[10])
                    || segundodigitoverificador >= 10 && 0 == Integer.parseInt(arr[10]);

            if (blprimeiro && blsegundo){
                createAccount.execute(domain);
            }else {
                new BalanceToWithdrawException("Dados inválido!");
            }
        }
    }
}

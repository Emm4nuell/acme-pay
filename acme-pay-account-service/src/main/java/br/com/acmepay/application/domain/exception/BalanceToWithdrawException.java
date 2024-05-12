package br.com.acmepay.application.domain.exception;

public class BalanceToWithdrawException extends Exception {

    public BalanceToWithdrawException(String message){
        super(message);
    }
}
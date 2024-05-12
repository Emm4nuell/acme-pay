package br.com.acmepay.adapters.output.repository;

import br.com.acmepay.adapters.output.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}

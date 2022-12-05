package br.com.excaladashboard.services;


import br.com.excaladashboard.models.Conta;
import br.com.excaladashboard.repositories.ContaRepository;
import com.facebook.ads.sdk.AdAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        return this.contaRepository.save(conta);
    }

    public Conta salvarContaPorAccount(AdAccount account) {
        Conta conta = new Conta();
        conta.setAccountId(account.getId());
        return this.contaRepository.save(conta);
    }

    @Transactional(readOnly = true)
    public Conta buscarConta(String accountId) {
        return this.contaRepository.buscarContaPorAccountId(accountId);
    }
}

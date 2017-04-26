package io.pivotal.mock;

import io.pivotal.Account;
import io.pivotal.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by prayoon-pc on 4/26/2017.
 */
@Slf4j
@Component
public class DataLoader {

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    public void loadData() {

        accountRepository.save(new Account("123456789","Keri Lee"));
        accountRepository.save(new Account("123456001","Dollie R. Schnidt"));
        accountRepository.save(new Account("123456002","Cornelia J. LeClerc"));
        accountRepository.save(new Account("123456003","Cynthia Rau"));
        accountRepository.save(new Account("123456004","Douglas R. Cobbs"));
        accountRepository.save(new Account("123456005","Michael Patel"));
        accountRepository.save(new Account("123456006","Suzanne Wong"));
        accountRepository.save(new Account("123456007","Ivan C. Jaya"));
        accountRepository.save(new Account("123456008","Ida Ketterer"));
        accountRepository.save(new Account("123456009","Laina Ochoa Lucero"));
        accountRepository.save(new Account("123456010","Wesley M. Montana"));
        accountRepository.save(new Account("123456011","Leslie F. McCleary"));
        accountRepository.save(new Account("123456012","Sayeed D. Mudra"));
        accountRepository.save(new Account("123456013","Pietronella J. Domingo"));
        accountRepository.save(new Account("123456014","John S. O''Leary"));
        accountRepository.save(new Account("123456015","Gladys D. Smith"));
        accountRepository.save(new Account("123456016","Sally O. Thygesen"));
        accountRepository.save(new Account("123456017","Rachel Vogt"));
        accountRepository.save(new Account("123456018","Julia DeLong"));
        accountRepository.save(new Account("123456019","Mark T. Rizzoli"));
        accountRepository.save(new Account("123456020","Maria J. Angelo"));

        log.info("Already mock Data completed !!!");
    }
}

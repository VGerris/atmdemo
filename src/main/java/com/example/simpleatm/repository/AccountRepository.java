package com.example.simpleatm.repository;

import com.example.simpleatm.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vgerris on 22/4/19.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}

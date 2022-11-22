package com.java.shopshore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.shopshore.entities.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
	@Query(value = "select * from Accounts where Username =?1", nativeQuery = true)
	Accounts findByUsername(String username);

	@Query(value = "select Count(Username) from Accounts where Username =?1 and Password =?2", nativeQuery = true)
	int loginAccount(String username, String password);
}

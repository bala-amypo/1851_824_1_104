package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.UserAccount;

public interface UserAccountRepository EmployeeProfileRepository extends JpaRepository<UserAccount, Long> {

}

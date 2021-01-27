package com.bankapp;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entities.Account;
import com.bankapp.entities.Employee;
import com.bankapp.service.AccountService;
import com.bankapp.service.EmployeeService;

@SpringBootApplication
public class OnlineBankAppApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(OnlineBankAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account account1 = new Account(6200.0, "SAVING", "venkatlaxmi", "Tekkali", "123456789", "lvrllj@gmail.com",
				"lvrllj", LocalDate.of(1973, Month.SEPTEMBER, 15));
		Account account2 = new Account(5600.0, "SAVING", "jyotshna", "Srikakulam", "123456897", "lj@gmail.com", "lj",
				LocalDate.of(2002, Month.JANUARY, 25));

		accountService.addAccount(account1);
		accountService.addAccount(account2);

		Employee employee1 = new Employee("sneha", "Srikakulam", "123546697", "sneha@gmail.com", "sneha",
				LocalDate.of(1999, Month.JUNE, 7), "EMP");
		Employee employee2 = new Employee("jyotshna", "Tekkali", "589546697", "jyotshna@gmail.com", "jyotshna",
				LocalDate.of(2003, Month.JANUARY, 25), "EMP");

		employeeService.addEmployee(employee1);
		employeeService.addEmployee(employee2);

	}

}

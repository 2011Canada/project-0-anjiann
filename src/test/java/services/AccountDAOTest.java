package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Account;
import repositories.AccountDAO;

public class AccountDAOTest {
	private AccountDAO accountDAO;
	
	@BeforeEach
	public void initialize() {
		this.accountDAO = new AccountDAO();
	}
	
	@Test
	public void testFindAccount() {
		Account account = accountDAO.findAccount("alecbatson");
		assert(account != null);
		assert(account.getAccountId() == 1);
	}
}

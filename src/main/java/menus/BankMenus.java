package menus;

import menus.CustomerViews.*;
import menus.EmployeeViews.*;
import services.AccountService;
import services.ServiceProvider;
import services.UserService;

public class BankMenus {
	private static BankMenus instance = new BankMenus();
	
	private MainMenu mainMenu;
	private LoginMenu loginMenu;
	private RegisterMenu registerMenu;
	
	private CustomerMenu customerMenu;
	private ApplicationMenu applicationMenu;
	private AccountMenu accountMenu;
	private BalanceMenu balanceMenu;
	private WithdrawMenu withdrawMenu;
	private DepositMenu depositMenu;
	private TransfersMenu transfersMenu;
	private PostTransferMenu postTransferMenu;
	private AcceptTransferMenu acceptTransferMenu;
	
	private EmployeeMenu employeeMenu;
	private AccountApprovalMenu accountApprovalMenu;
	private AccountsViewMenu accountsViewMenu;
	private TransactionsMenu transactionsMenu;
	
	private BankMenus() {
		mainMenu = new MainMenu();
		loginMenu = new LoginMenu();
		registerMenu = new RegisterMenu();
		
		customerMenu = new CustomerMenu();
		applicationMenu = new ApplicationMenu();
		accountMenu = new AccountMenu();
		balanceMenu = new BalanceMenu();
		withdrawMenu = new WithdrawMenu();
		depositMenu = new DepositMenu();
		transfersMenu = new TransfersMenu();
		postTransferMenu = new PostTransferMenu();
		acceptTransferMenu = new AcceptTransferMenu();
		
		employeeMenu = new EmployeeMenu();
		accountApprovalMenu = new AccountApprovalMenu();
		transactionsMenu = new TransactionsMenu();
		accountsViewMenu = new AccountsViewMenu();
	}

	public static BankMenus getInstance() {
		return instance;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public LoginMenu getLoginMenu() {
		return loginMenu;
	}

	public RegisterMenu getRegisterMenu() {
		return registerMenu;
	}

	public CustomerMenu getCustomerMenu() {
		return customerMenu;
	}
	
	public ApplicationMenu getApplicationMenu() {
		return applicationMenu;
	}
	
	public AccountMenu getAccountMenu() {
		return accountMenu;
	}

	public BalanceMenu getBalanceMenu() {
		return balanceMenu;
	}

	public WithdrawMenu getWithdrawMenu() {
		return withdrawMenu;
	}

	public DepositMenu getDepositMenu() {
		return depositMenu;
	}

	public TransfersMenu getTransfersMenu() {
		return transfersMenu;
	}

	public PostTransferMenu getPostTransferMenu() {
		return postTransferMenu;
	}

	public AcceptTransferMenu getAcceptTransferMenu() {
		return acceptTransferMenu;
	}

	public EmployeeMenu getEmployeeMenu() {
		return employeeMenu;
	}

	public AccountApprovalMenu getAccountApprovalMenu() {
		return accountApprovalMenu;
	}

	public AccountsViewMenu getAccountsViewMenu() {
		return accountsViewMenu;
	}
	
	public TransactionsMenu getTransactionsMenu() {
		return transactionsMenu;
	}
}

package fr.bts.iris.slam.banking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    
    private BankAccount account;
    private final String ACCOUNT_NUMBER = "ACC001";
    private final String HOLDER_NAME = "Alice Dupont";
    private final double INITIAL_BALANCE = 100.0;
    
    @BeforeEach
    void setUp() {
        account = new BankAccount(ACCOUNT_NUMBER, HOLDER_NAME, INITIAL_BALANCE);
    }
    
    // === TESTS DE CONSTRUCTION ===
    @Test
    void shouldCreateAccountWithValidParameters() {
        // ARRANGE & ACT - Création d'un nouveau compte
        BankAccount newAccount = new BankAccount("ACC002", "Bob Martin", 50.0);
        
        //
        assertEquals("ACC002", newAccount.getAccountNumber());
        assertEquals("Bob Martin", newAccount.getHolderName());
        assertEquals(50.0, newAccount.getBalance());
        assertTrue(newAccount.isActive());
        assertEquals(0.0, newAccount.getOverdraftLimit());
    }
    @Test
    void shouldRejectNullAccountNumber() {
        // ARRANGE & ACT - Création d'un nouveau compte + ASSERT - Vérification
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount newAccount = new BankAccount(null, "Bob Martin", 50.0);
        });
    }
    @Test
    void shouldRejectEmptyAccountNumber() {
        // ARRANGE & ACT - Création d'un nouveau compte + ASSERT - Vérification
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount newAccount = new BankAccount("", "Bob Martin", 50.0);
        });
    }
    @Test
    void shouldRejectNullHolderName() {
        // ARRANGE & ACT - Création d'un nouveau compte + ASSERT - Vérification
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount newAccount = new BankAccount("ACC002", null, 50.0);
        });
    }
    @Test
    void shouldRejectEmptyHolderName() {
        // ARRANGE & ACT - Création d'un nouveau compte + ASSERT - Vérification
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount newAccount = new BankAccount("ACC002", "", 50.0);
        });
    }
    @Test
    void shouldRejectNegativeInitialBalance() {
        // ARRANGE & ACT - Création d'un nouveau compte + ASSERT - Vérification
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount newAccount = new BankAccount("ACC002", "Bob Martin", -50.0);
        });
    }
    @Test
    void shouldAcceptZeroInitialBalance() {
        // ARRANGE & ACT
        BankAccount zeroAccount = new BankAccount("ACC003", "Charlie", 0.0);
        
        // ASSERT
        assertEquals(0.0, zeroAccount.getBalance());
    }
    
    // === TESTS DE DÉPÔT ===
    @Test
    void shouldIncreaseBalanceOnValidDeposit() {
        // ARRANGE
        double initialBalance = account.getBalance();
        double depositAmount = 50.0;
        
        // ACT
        account.deposit(depositAmount);
        
        // ASSERT
        assertEquals(initialBalance + depositAmount, account.getBalance());
    }
    @Test
    void shouldRejectZeroDeposit() {
        // ARRANGE
        double initialBalance = account.getBalance();
        double depositAmount = 0.0;

        // ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(depositAmount);
        });
    }
    @Test
    void shouldRejectNegativeDeposit() {
        // ARRANGE
        double initialBalance = account.getBalance();
        double depositAmount = -50.0;

        // ACT + ASSERT
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(depositAmount);
        });
    }
    @Test
    void shouldRejectDepositOnInactiveAccount() {
        // ARRANGE
        account.deactivate();
        
        // ACT & ASSERT
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            () -> account.deposit(50.0)
        );
        
        // Vérification optionnelle du message
        // assertTrue(exception.getMessage().contains("not active") || exception.getMessage().contains("inactive"));
    }
    
    // === TESTS DE RETRAIT ===
    @Test
    void shouldDecreaseBalanceOnValidWithdrawal() {
        // ACT
        account.withdraw(30.0);

        //ASSERT
        assertEquals(70.0, account.getBalance());
    }
    @Test
    void shouldRejectWithdrawalExceedingBalance() {
        // ACT & ASSERT
        assertThrows(
                IllegalArgumentException.class, () -> account.withdraw(150.0)
        );
    }
    @Test
    void shouldAllowWithdrawalWithinOverdraftLimit() {
        // ARRANGE
        account.setOverdraftLimit(50.0);
        double withdrawalAmount = 130.0; // Plus que le solde mais dans la limite
        
        // ACT
        account.withdraw(withdrawalAmount);
        
        // ASSERT
        assertEquals(-30.0, account.getBalance()); // 100 - 130 = -30
    }
    @Test
    void shouldRejectWithdrawalExceedingOverdraftLimit() {
        // ARRANGE
        account.setOverdraftLimit(50.0);
        double withdrawalAmount = 160.0; // Plus que le solde et hors dans la limite

        // ACT & ASSERT
        assertThrows(
                IllegalArgumentException.class, () -> account.withdraw(withdrawalAmount)
        );
    }
    @Test
    void shouldRejectWithdrawalOnInactiveAccount() {
        // ARRANGE
        account.deactivate();
        double withdrawalAmount = 30.0;

        // ACT & ASSERT
        assertThrows(
                IllegalStateException.class, () -> account.withdraw(withdrawalAmount)
        );
    }
    @Test
    void shouldRejectNegativeWithdrawal() {
        // ARRANGE
        double withdrawalAmount = -30.0;

        // ACT & ASSERT
        assertThrows(
                IllegalArgumentException.class, () -> account.withdraw(withdrawalAmount)
        );
    }
    
    // === TESTS DE TRANSFERT ===
    @Test
    void shouldTransferMoneyBetweenAccounts() {
        // ARRANGE
        BankAccount targetAccount = new BankAccount("ACC002", "Bob Martin", 0.0);
        double transferAmount = 30.0;
        double initialSourceBalance = account.getBalance();
        double initialTargetBalance = targetAccount.getBalance();
        
        // ACT
        account.transfer(targetAccount, transferAmount);
        
        // ASSERT
        assertEquals(initialSourceBalance - transferAmount, account.getBalance());
        assertEquals(initialTargetBalance + transferAmount, targetAccount.getBalance());
    }
    @Test
    void shouldRejectTransferWithInsufficientFunds() {
        // ARRANGE
        BankAccount targetAccount = new BankAccount("ACC002", "Bob Martin", 0.0);
        double transferAmount = 130.0;
        double initialSourceBalance = account.getBalance();
        double initialTargetBalance = targetAccount.getBalance();

        // ACT & ASSERT
        assertThrows(IllegalArgumentException.class, () -> account.transfer(targetAccount, transferAmount));
    }
    @Test
    void shouldRejectTransferToNullAccount() {
        // ARRANGE
        BankAccount targetAccount = new BankAccount("ACC002", "Bob Martin", 0.0);
        double transferAmount = 30.0;
        double initialSourceBalance = account.getBalance();
        double initialTargetBalance = targetAccount.getBalance();

        // ACT & ASSERT
        assertThrows(IllegalArgumentException.class, () -> account.transfer(new BankAccount(null, "Bob Martin", 0.0), transferAmount));
    }
    @Test
    void shouldRejectTransferToInactiveAccount() {
        // ARRANGE
        BankAccount targetAccount = new BankAccount("ACC002", "Bob Martin", 0.0);
        targetAccount.deactivate();
        double transferAmount = 30.0;
        double initialSourceBalance = account.getBalance();
        double initialTargetBalance = targetAccount.getBalance();

        // ACT & ASSERT
        assertThrows(IllegalStateException.class, () -> account.transfer(targetAccount, transferAmount));
    }
    @Test
    void shouldRejectTransferFromInactiveAccount() {
        // ARRANGE
        BankAccount targetAccount = new BankAccount("ACC002", "Bob Martin", 0.0);
        account.deactivate();
        double transferAmount = 30.0;
        double initialSourceBalance = account.getBalance();
        double initialTargetBalance = targetAccount.getBalance();

        // ACT & ASSERT
        assertThrows(IllegalStateException.class, () -> account.transfer(targetAccount, transferAmount));
    }
    
    // === TESTS D'ACTIVATION/DÉSACTIVATION ===
    @Test
    void shouldDeactivateAccount() {
        // ARRANGE
        assertTrue(account.isActive());
        
        // ACT
        account.deactivate();
        
        // ASSERT
        assertFalse(account.isActive());
    }
    @Test
    void shouldActivateAccount() {
        // ARRANGE
        account.deactivate();
        assertFalse(account.isActive());
        
        // ACT
        account.activate();
        
        // ASSERT
        assertTrue(account.isActive());
    }
    
    // === TESTS LIMITE DE DÉCOUVERT ===
    @Test
    void shouldSetValidOverdraftLimit() {
        // ARRANGE
        double newLimit = 100.0;
        
        // ACT
        account.setOverdraftLimit(newLimit);
        
        // ASSERT
        assertEquals(newLimit, account.getOverdraftLimit());
    }
    @Test
    void shouldRejectNegativeOverdraftLimit() {
        // ARRANGE
        double newLimit = -100.0;

        // ACT & ASSERT
        assertThrows(IllegalArgumentException.class, () -> account.setOverdraftLimit(newLimit));
    }
    
    // === TESTS DES MÉTHODES UTILITAIRES ===
    @Test
    void shouldCalculateAvailableBalanceCorrectly() {
        // ARRANGE
        account.setOverdraftLimit(50.0);
        
        // ACT & ASSERT
        assertEquals(150.0, account.getMaxAvailableBalance()); // 100 + 50
    }
    @Test
    void shouldReturnTrueWhenCanWithdraw() {
        // ACT & ASSERT
        assertTrue(account.canWithdraw(30.0));
    }
    @Test
    void shouldReturnFalseWhenCannotWithdraw() {
        // ACT & ASSERT
        assertFalse(account.canWithdraw(130.0));
    }
    @Test
    void shouldReturnFalseWhenCanWithdrawOnInactiveAccount() {
        // ARRANGE
        account.deactivate();
        
        // ACT & ASSERT
        assertFalse(account.canWithdraw(50.0));
    }
    
    // === TESTS DE SCÉNARIOS COMPLEXES ===
    @Test
    void shouldHandleMultipleOperationsCorrectly() {
        // ARRANGE
        assertEquals(100.0, account.getBalance());
        
        // ACT - Série d'opérations
        account.deposit(50.0);    // Solde : 150.0
        account.withdraw(30.0);   // Solde : 120.0
        account.deposit(20.0);    // Solde : 140.0
        
        // ASSERT
        assertEquals(140.0, account.getBalance());
        assertTrue(account.isActive());
    }
    @Test
    void shouldMaintainConsistencyAfterFailedOperation() {
        // ARRANGE
        double initialBalance = account.getBalance();
        
        // ACT - Tentative d'opération invalide
        try {
            account.withdraw(1000.0); // Doit échouer
        } catch (IllegalArgumentException e) {
            // Attendu
        }
        
        // ASSERT - L'état ne doit pas avoir changé
        assertEquals(initialBalance, account.getBalance());
        assertTrue(account.isActive());
    }
}
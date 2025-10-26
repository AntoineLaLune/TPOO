package fr.bts.iris.slam.banking;

public class BankAccount {

    // === ATTRIBUTS ===
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected boolean isActive;
    protected double overdraftLimit; // Découvert autorisé

    // === CONSTRUCTOR ===
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account Number can't be empty");
        }
        if (holderName == null || holderName.isEmpty()) {
            throw new IllegalArgumentException("Holder Name can't be empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial Balance can't be lower than 0");
        }
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.isActive = true;
        this.overdraftLimit = 0;
        // TODO: Implémenter la logique du constructor et init la classe
    }

    // === METHODS ===
    public void deposit(double amount) {
        if (this.balance + amount < 0) {
            throw new IllegalArgumentException("Balance is to short for the deposit");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Balance can't be 0 nor lower");
        }
        if (!this.isActive) {
            throw new IllegalStateException("Account need to be active");
        }
        this.balance = this.balance + amount;
    }
    public void withdraw(double amount) {
        if (!this.isActive) {
            throw new IllegalStateException("The host account need to be active");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Balance can't be 0 nor lower");
        }
        if (canWithdraw(amount)) {
            if (!this.isActive) {
                throw new IllegalStateException("Account need to be active");
            }
            this.balance = this.balance - amount;
        } else {
            throw new IllegalArgumentException("The withdraw amount ("+amount+") is higher than the balance ("+this.balance+") with overdraft limit ("+this.overdraftLimit+")");
        }

    }
    public void transfer(BankAccount targetAccount, double amount) {
        if (!this.isActive) {
            throw new IllegalStateException("The host account need to be active");
        }
        if (!targetAccount.isActive) {
            throw new IllegalStateException("The target account need to be active");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Balance can't be 0 nor lower");
        }
        if (targetAccount.accountNumber == null || targetAccount.accountNumber.isEmpty()) {
            throw new IllegalArgumentException("The target account can't be empty");
        }
        if (this.canWithdraw(amount)) {
            this.balance = this.balance - amount;
            targetAccount.balance = targetAccount.balance + amount;
        } else {
            throw new IllegalArgumentException("The withdraw amount ("+amount+") is higher than the balance ("+this.balance+") with overdraft limit ("+this.overdraftLimit+")");
        }
    }
    public void deactivate() {
        this.isActive = false;
    }
    public void activate() {
        this.isActive = true;
    }
    public void setOverdraftLimit(double limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("The limit for the overdraft can't be lower than 0");
        }
        this.overdraftLimit = limit;
    }
    public boolean canWithdraw(double amount) {
        if (!this.isActive) {
            return false;
        }
        if (amount <= 0) {
            return false;
        }
        if (this.balance - amount < -this.overdraftLimit) {
            return false;
        }
        return true;
    }
    
    // === GETTERS ===
    public String getAccountNumber() {
        return this.accountNumber;
    }
    public String getHolderName() {
        return this.holderName;
    }
    public double getBalance() {
        return this.balance;
    }
    public boolean isActive() {
        return this.isActive;
    }
    public double getOverdraftLimit() {
        return this.overdraftLimit;
    }
    public double getMaxAvailableBalance() {
        return this.balance + this.overdraftLimit;
    }
    
    @Override
    public String toString() {
        return String.format("BankAccount{number='%s', holder='%s', balance=%.2f, active=%s, overdraft=%.2f}", 
                           this.accountNumber, this.holderName, this.balance, this.isActive, this.overdraftLimit);
    }
}
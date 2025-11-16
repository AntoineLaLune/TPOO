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
            throw new IllegalArgumentException("Account Number can't be null or empty");
        }
        if (holderName == null || holderName.isEmpty()) {
            throw new IllegalArgumentException("Holder Name can't be null or empty");
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
        if (amount <= 0) {
            throw new IllegalArgumentException("Can't deposit a amount that is 0 nor lower");
        }
        if (!this.isActive) {
            throw new IllegalStateException("Can't deposit on inactive account");
        }
        this.balance = this.balance + amount;
    }
    public void withdraw(double amount) {
        if (!this.isActive) {
            throw new IllegalStateException("Can't withdraw on inactive account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Can't withdraw a amount that is 0 nor lower");
        }
        if (canWithdraw(amount)) {
            if (!this.isActive) {
                throw new IllegalStateException("Can't withdraw on quantum account");
            }
            this.balance = this.balance - amount;
        } else {
            throw new IllegalArgumentException("Cannot withdraw over the overdraft limit : "+this.balance+" - "+amount+" < "+this.overdraftLimit);
        }

    }
    public void transfer(BankAccount targetAccount, double amount) {
        if (!this.isActive) {
            throw new IllegalStateException("Can't transfer with a inactive account involve : host account");
        }
        if (!targetAccount.isActive) {
            throw new IllegalStateException("Can't transfer with a inactive account involve : target account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Can't transfert amount that is 0 nor lower");
        }
        if (targetAccount.accountNumber == null || targetAccount.accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Can't transfert on null or empty target account number");
        }
        if (this.canWithdraw(amount)) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
        } else {
            throw new IllegalArgumentException("Cannot withdraw over the overdraft limit : "+this.balance+" - "+amount+" < "+this.overdraftLimit);
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
            throw new IllegalStateException("Can't set a overdraft limit that is lower than 0");
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
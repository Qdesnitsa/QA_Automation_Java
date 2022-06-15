PRAGMA foreign_keys=off;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS transactions;
CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT, 
    name VARCHAR(50) NOT NULL, 
    address VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
    );
CREATE TABLE IF NOT EXISTS accounts (
    account_id INTEGER PRIMARY KEY AUTOINCREMENT, 
    user_id INTEGER(10) NOT NULL, 
    balance DECIMAL(15,3), 
    currency VARCHAR(10) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
    );
CREATE TABLE IF NOT EXISTS transactions (
    transaction_id INTEGER PRIMARY KEY AUTOINCREMENT, 
    type_transaction VARCHAR(255) NOT NULL,
    account_id INTEGER(10) NOT NULL, 
    amount DECIMAL(15,3),
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
    );
PRAGMA foreign_keys=on;
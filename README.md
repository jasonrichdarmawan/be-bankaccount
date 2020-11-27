## CI/CD environment

- Git
- Docker Engine
- Docker Compose

## Coding Styles

To reduce boilerplate, follow this coding styles.

### Model used by @ResponseBody
@ResponseBody can convert JSON to Object without setters or constructor:

- No attribute with `_`.
  - `String full_Name` is invalid.
- Use camelCase.
  - `String fullName` is valid.
- No defined constructor.
  ```
  public model(String fullName) {
    this.fullName = fullName;
  }
  ```
- Use @JsonProperty("attribute")
  ```
  @JsonProperty("Full_Name")
  String fullName;
  ```

### Model used by @Mapper
@Mapper can convert `ResultSet` to Object without setters and constructor:

- Attribute should be identical to the column.
  - A table with column `Full_Name`
    - `String full_Name` is invalid.
    - `String Full_Name` is valid.
- No defined constructor.
  ```
  public model(String Full_Name) {
    this.Full_Name = Full_Name;
  }
  ```
  
### Validation

Maintainability in this case: You don't have to read the entire method if you wish to modify a validation logic. You only need to write the new check on top of the existing logic.

For maintainability, write the validation logic with "the checks is on the top, while the result is on the below" in mind:

```
boolean isValid;

if (false) {
  isValid = false;
} else if (true) {
  isValid = true;
}

return isValid;
```

## To Do
- [ ] GitHub self-hosted runners, to prevent unauthorized access to ssh port 22

- [x] BE: Endpoint
  - [x] Post `api/v1/register`
    - [x] INSERT INTO table `user_login`
      - [x] Hash the PIN in `column Hashed_PIN` with format `iterations:salt:hash`
    - [x] INSERT INTO table `user_info`
    - [x] INSERT INTO table `user_detail`
  - [x] Post `api/v1/login`
    - [x] Validate `storedhashed_pin` with `PIN` from @RequestBody
  - [x] Post `api/v1/token`
    - [x] Refresh Access Token
  - [x] Get `api/v1/account`
    - [x] Get Account Info By Account Number
  - [x] Get `api/v1/history`
    - [x] Get Transactions History By Start and End Date
  - [x] Post `api/v1/transaction`
    - [x] Post Transaction
      - [x] INSERT INTO table `transactions`
  - [x] Get `api/v1/balance`
    - [x] Get Account Balance
      - [x] SELECT Ending_Balance FROM table `statements` WHERE Account_Number=#{Account_Number} AND Month=#{PreviousMonth} AND YEAR=#{Year}
        - [x] IF NOT EXISTS, Ending Balance = 0
      - [x] Debit: SELECT Transaction_Value FROM table `transactions` WHERE Source=#{Account_Number}
      - [x] Credit: SELECT Transaction_Value FROM table `transactions` WHERE Destination=#{Account_Number}

- [ ] BE: Extra Todos
  - [x] Refactor the code to use RabbitMQ
  - [ ] Pattern Tester / bug prevention
    - [x] RegisterController
      - [x] post "api/v1/register" Full_Name pattern tester to generate User_ID with format: First_NameSecond_Nameddyy
    - [x] TransactionsController
      - [x] post "api/v1/transaction" pattern tester
      - [x] get "api/v1/history" pattern tester to prevent expensive query (more info on the source code)
    - [x] AccountInfoController
      - [x] get "api/v1/account" pattern tester
    - [ ] Refactor the Pattern Tester to the Model, for better readibility.
  - [ ] post "api/v1/register" rollback feature if the process fail.
  - [ ] SQL Injection prevention (will be defined later)
  - [ ] Tests (will be defined later)
  - [ ] Container timezone.
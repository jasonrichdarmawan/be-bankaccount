## To Do
- [ ] GitHub self-hosted runners, to prevent unauthorized access to ssh port 22

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
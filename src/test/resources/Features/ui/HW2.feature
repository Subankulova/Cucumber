Feature:Verify sorting functionality
  Scenario: Verify user can sort the product by price high to low
    Given user open website
    Then verify user is on login page
    When user login with username "login.username" and password "login.password"
    Then verify user is on home page
    When user click on sort button
    And select the product by price high to low
    Then verify products are displayed by price high to low


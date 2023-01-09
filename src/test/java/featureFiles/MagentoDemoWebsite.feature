#Author: mostafa.alsaddek@ibm.com

Feature: Magento-demo
  
  
		# ---------------------
		# ---------------------
		# Task 1: >>>>
		# ---------------------
		# ---------------------
		
  Scenario: I want to register

    Given I successfully connected to the Landing page using label "This is a demo Magento"
    
    When I click on register button
    Then I get the registeration page using label "Create an Account"
		
		When  I fill all registration data from the excel file located in "src/main/resources/Registeration_data.xlsx"
		And I click register
		Then I assert that I registered successfully using "Thank you for registering with Madison Island"
		
		
	 Scenario: I want to register with old registered email
		Given I successfully connected to the Landing page using label "This is a demo Magento"
    
    When I click on register button
    Then I get the registeration page using label "Create an Account"
		
		When  I fill all registration data from the excel file located in "src/main/resources/Registeration_data.xlsx"
		And I click register
		Then I assert that I found an error message as "There is already an account with this email address"
		
		
			 Scenario: I want to register with small password
		Given I successfully connected to the Landing page using label "This is a demo Magento"
    
	   When I click on register button
    Then I get the registeration page using label "Create an Account"
		
		When  I fill all registration data from the excel file located in "src/main/resources/Registeration_data_small_password.xlsx"
		And I click register
		Then I assert that I found an error message as "The minimum password length is 6"
		
					 Scenario: I want to register with wrong email 
		Given I successfully connected to the Landing page using label "This is a demo Magento"
    
    When I click on register button
    Then I get the registeration page using label "Create an Account"
		
		When  I fill all registration data from the excel file located in "src/main/resources/Registeration_data_wrong_email.xlsx"
		And I click register
		Then I assert that I found an error message as "is not a valid hostname"
		
		
		
		
		
		
		# ---------------------
		# ---------------------
		# Task 2: >>>>
		# ---------------------
		# ---------------------
		
		
		
		  Scenario: I want to buy something

    Given I successfully connected to the Landing page using label "This is a demo Magento"
    
  # login process
    When I click on Login button
    Then I get the Login page using label "Login or Create an Account"
		When  I fill all login data from the excel file located in "src/main/resources/Login_data.xlsx"
		And I click login
		Then I assert that I login successfully using "Hello"
		
	# "selecting" and "add to cart" process
		When I hover on the WOMEN Pants & Denim menu
		Then I assert there is at least one product

		When I view details of any of the items
	# color and size are empty list, Thay are mandatory to processed to the cart. I get the locators but I can not complete the task
		And I select the Color & Size  
		And I add the item to your cart.    
		Then I assert on the Grand Total is less than you budget of 350 dollor
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
Feature: SignUP & Login 
	In order to Login to a JainBookAgencyPage
    As a e commerce customer 
    I want to Login  and search for Books .
    
Background: 
	Given I have browser with  JainBookAgencyPage 
	
Scenario: ValidSign_upDetails 

	When I enter details from excel 'src/test/resources/excel/jain books.xlsx' with sheet name 'sign up' 
	Then I should create an account successfully. 
	
	
Scenario: inValidSign_upDetails 
	When I enter  invalid details from excel 'src/test/resources/excel/jain books.xlsx' with sheet name 'invalid sign up' 
	Then I should get a error message 
	
Scenario: ValidLogin 

	When I enter valid details from excel 'src/test/resources/excel/jain books.xlsx' with sheet name 'valid login' 
	Then I should login successfully and  search for books. 
	
Scenario: inValid mail Login 
	When I enter invalid mail i from excel 'src/test/resources/excel/jain books.xlsx' with sheet name 'invalid login' 
	Then I should get a invalid mailId message displayed as "Unable To Login: Email/Password Is Invalid" 
	
Scenario: inValidpassword login 
	When I enter invalid password from excel 'src/test/resources/excel/jain books.xlsx' with sheet name 'invalid login' 
	Then I should get a inValid password  message displayed as "Unable To Login: Email/Password Is Invalid" 
	
	
	
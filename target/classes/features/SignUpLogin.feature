Feature: SignUP & Login 
	In order to Login to a JainBookAgencyPage
    As a e commerce customer 
    I want to Login  and search for Books .
    
Background: 
	Given I have browser with  JainBookAgencyPage 
	
Scenario: ValidSign_upDetails 

	When I enter <validmailId> as '22001155@gmail.com' ,I enter <repeatEmailAddress> as '22001155@gmail.com', I enter <validpassword> as '12345678' and I enter <Repeat Password> as '12345678' 
	Then I should create an account successfully. 
	
	
Scenario: inValidSign_upDetails 

	When I enter <invalidmailId> as '122001155' ,I enter <repeatEmailAddress> as '122001155@gmail.com', I enter <password> as 'chinni2015' and I enter <Repeat Password> as 'chinni2015' 
	Then I should get a error message 
	
@valid 
Scenario: ValidLogin 
	When I enter <mailId> as 'specter@gmail.com' ,I enter <validpassword> as 'specter123' 
	Then I should login successfully and  search for books. 
	
Scenario: inValid mail Login 
	When I enter <invalidmailId> as 'abcde@gmail.com' , I enter <password> as '12345678' 
	Then I should get a invalid mailId message displayed as "Unable To Login: Email/Password Is Invalid" 
	
Scenario: inValidpassword login 
	When I enter <mailId> as 'harvey@gmail.com' , I enter <invalidpassword> as '12345678' 
	Then I should get a inValid password  message displayed as "Unable To Login: Email/Password Is Invalid" 
		
	
	
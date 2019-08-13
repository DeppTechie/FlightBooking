Feature:  Sydney-Brisbane Travel Booking

Scenario Outline: Book airline tickets with increasing numer of additional bags till 5 

Given I launch the Qantas Website for an user
  And I choose the right destination
      And I choose the right dates
     Then I do initial price check
     Then I add the favorite Red Deal
     Then I do the Update Price Check
     Then I Add Luggage based on number of <users>
     
  Examples: 
    | users | 
    |5|
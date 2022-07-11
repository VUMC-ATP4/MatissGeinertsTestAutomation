Feature: Sauce demo  login feature

  Scenario: User can login with correct username/password
    Given user navigates to 'https://www.google.com/'
    #When user enters 'standard_user' and 'secret_sauce'
    #And user clicks login button
    #Then user sees inventory page
  Then user sees page title 'Google'

    Given user navigates to 'https://www.rtu.lv/'
    Then user sees page title 'Rīgas Tehniskā universitāte | Inženierzinātņu centrs Baltijā'

    Given user navigates to 'https://www.llu.lv/'
    Then user sees page title 'Latvijas Lauksaimniecības universitāte'



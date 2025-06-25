Feature: NHS Job Search Functionality
  
  As a jobseeker on NHS Jobs website
  I want to search for a job with my preferences
  So that I can get recently posted job results

  @Regression @ChromeBrowser
  Scenario Outline: TC-01:Jobseeker searches for a job and sorts by newest date posted via Chromebrowser
    Given I am a jobseeker on NHS Jobs website
    When I put "<jobTitle>" and "<location>" into the Search functionality
    Then I should get a list of jobs which matches my preferences
    And sort my search results with "<Sorted Option>"  and from dropdown "<id>"

    Examples: 
      | jobTitle                 | location    | Sorted Option        | id   |
      | Automation Test Engineer | London      | Date Posted (newest) | sort |
      | QA                       | Southampton | Date Posted (newest) | sort |
      | QA engineer              | England     | Date Posted (newest) | sort |
      | Moon                     |             | Date Posted (newest) | sort |

  @Regression1 @FireFoxBrowser
  Scenario Outline: TC-02: Jobseeker searches for a job and sorts by newest date posted via Firefox Browser
    Given I am a jobseeker on NHS Jobs website
    When I put "<jobTitle>" and "<location>" into the Search functionality
    Then I should get a list of jobs which matches my preferences
    And sort my search results with "<Sorted Option>"  and from dropdown "<id>"

    Examples: 
      | jobTitle               | location    | Sorted Option        | id   |
      | Software Test Engineer | London      | Date Posted (newest) | sort |
      | QA Automation engineer | Southampton | Date Posted (newest) | sort |
      | QA engineer            | Southampton | Date Posted (newest) | sort |

  @NegativeTests @ChromeBrowser
  Scenario Outline: TC-03:Jobseeker searches for a invalid job/locations via chrome browser
    Given I am a jobseeker on NHS Jobs website
    When I put "<jobTitle>" and "<location>" into the Search functionality
    Then Validate the error message
      | ErrorMsg   |
      | <ErrorMsg> |

    Examples: 
      | jobTitle          | location          | ErrorMsg             |
      | 1234567           | London            | no result found      |
      | -------------     | London            | no result found      |
      | -------------     | London1111111     | location not found   |
      | Software Testing  | Ep1111111         | location not found   |
      | A                 | L                 | no result found      |
      | Nurse             | !@#$%^&*          | location not found   |
      | <256-char-string> | London            | no result found      |
      | Nurse             | <256-char-string> | location not found   |

  @Regression3 @ChromeBrowser
  Scenario Outline: TC-04:Jobseeker searches for a job and sorts by newest date posted with all filtered values via chrome browser
    Given I am a jobseeker on NHS Jobs website
    When I put all values into the Search functionality
      | jobTitle   | location   | jobReference   | employer   | distance   | payRange   |
      | <jobTitle> | <location> | <jobReference> | <employer> | <distance> | <payRange> |
    Then I should get a list of jobs which matches my preferences
    And sort my search results with "<Sorted Option>"  and from dropdown "<id>"

    Examples: 
      | jobTitle | location | jobReference  | employer                    | distance | payRange           | Sorted Option        | id   |
      | Nurse    | London   | 391-3689-BANK | Thomas NHS Foundation Trust | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort |
      | Nurse    | London   |               | Thomas NHS Foundation Trust | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort |

  @Regression4 @FireFoxBrowser
  Scenario Outline: TC-05:Jobseeker searches for a job and sorts by newest date posted with all filtered values via frefox browser
    Given I am a jobseeker on NHS Jobs website
    When I put all values into the Search functionality
      | jobTitle   | location   | jobReference   | employer   | distance   | payRange   |
      | <jobTitle> | <location> | <jobReference> | <employer> | <distance> | <payRange> |
    Then I should get a list of jobs which matches my preferences
    And sort my search results with "<Sorted Option>"  and from dropdown "<id>"

    Examples: 
      | jobTitle | location | jobReference  | employer                    | distance | payRange           | Sorted Option        | id   |
      | Nurse    | London   | 391-3689-BANK | Thomas NHS Foundation Trust | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort |
      | Nurse    | London   |               | Thomas NHS Foundation Trust | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort |
      |          | London   |               | Thomas NHS Foundation Trust | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort |

  @NegativeTests1 @FireFoxBrowser
  Scenario Outline: TC-06:Jobseeker searches for  invalid values with all filtered values via firefox browser
    Given I am a jobseeker on NHS Jobs website
    When I put all values into the Search functionality
      | jobTitle   | location   | jobReference   | employer   | distance   | payRange   |
      | <jobTitle> | <location> | <jobReference> | <employer> | <distance> | <payRange> |
    Then Validate the error message
      | ErrorMsg   |
      | <ErrorMsg> |

    Examples: 
      | jobTitle | location          | jobReference  | employer                    | distance | payRange           | Sorted Option        | id   | ErrorMsg              |
      | Nurse    | 11111111111111111 | 391-3689-BANK | Thomas NHS Foundation Trust | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort |                       |
      | Nurse    | London            | aaaaa         | Thomas NHS Foundation Trust | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort | no result found       |
      | Nurse    | London            | 391-3689-BANK |             111111111111111 | +5 Miles | £30,000 to £40,000 | Date Posted (newest) | sort | invalid employer      |
      
      
      
      
      
      #End

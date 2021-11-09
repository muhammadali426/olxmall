Feature:  Navigate to OlX Mall

Scenario Outline: Postive test 
    Given Navigate to"https://www.olx.com.pk/" site
      And Navigate to All Categories -> Mobiles & Tablets -> Mobiles
     When Filter Listings by PRICE between <Range1> - <Range2> 
     Then Validate the first ten results to ensure search results that they are from Mobile category and in given price range 
     And Please note that the to validate the category you will need to 'visit' the details page by tapping on the result
  
Examples:
| Range1 | Range2 |
| 4000  | 20000 |



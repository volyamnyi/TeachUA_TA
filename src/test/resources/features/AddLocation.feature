Feature: Verify that a 'Керівник' can add a location to the list of locations
  Scenario Outline: This test case verifies that a 'Керівник' can add location to the list of locations after filling in all mandatory and all optional fields with valid data
  Given Log in as an Керівник
  And Go to the 'Додати центр'
  When Click on '+Додати локацію' button
  And Fill 'Назва' field with correct value <validLocationName>
  And Select Київ from the city dropdown list
  And Select Академмістечко from the dropdown list
  And Select Деснянський from the dropdown list
  And Fill in 'Адреса' field with <validAddress>
  And Fill in 'Координати' field with <validCoordinates>
  And Fill in 'Номер телефону' field with <validPhoneNumber>
  And Click on 'Додати' button
  Then Location <validLocationName> is in the list of locations
  Examples:
  | validLocationName | validAddress | validCoordinates | validPhoneNumber |
  | ValidLocationName | ValidAddress | 49.829104498711104, 24.005058710351314 | 0976855546 |
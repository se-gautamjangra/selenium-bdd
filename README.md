# selenium-bdd

This project is devloped using below technologies:
1. Java
2. Selenium
3. Rest Assured
4. Cucumber
5. Reporting - Maven Cucumber Reporting

### Project details:
UI Tests:
```Customer navigation through product categories: Phones, Laptops and Monitors
   • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up
   confirmation.
   • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up
   confirmation.
   • Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
   • Click on "Place order".
   • Fill in all web form fields.
   • Click on "Purchase"
   • Capture and log purchase Id and Amount.
   • Assert purchase amount equals expected.
   • Click on "Ok".
```

API Tests:
```Get "available" pets. Assert expected result
   • Post a new available pet to the store. Assert new pet added.
   • Update this pet status to "sold". Assert status updated.
   • Delete this pet. Assert deletion.
```

OUTPUT:
filename - test/resources/output.properties
```#Fri Oct 16 19:59:49 IST 2020
   product.details=Id\: 1565370\nAmount\: 790 USD\nCard Number\: 9012345678\nName\: Gautam\nDate\: 16/9/2020
   petId=9217336407590485220
```
Order details and new pet ID both saved in output.properties

###Test Execution
run below command to run test cases:

```mvn clean install```
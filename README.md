
## Run all tests
```
mvn clean test
```

## Open report
```
mvn allure:serve
```

## Notes

 - Assumption is that checkout process was done and tested in different task. Therefore, the new changes cover only updates in total items section.
 - There are commented out assertions for total price in different places. It seems that if several items have same discount, discount is calculated not per item, but for total sum. 
> Example: 
> 1 item is 18.68, with 20% discount that's 14.94. So 3 items would be 44.82. 
> But if we count 3 items (18.68*3=56.04) and then apply discount total sum would be 44.83. 

From my point of view it seems inconsistent for user, so I would discuss this scenario within team and then make changes to tests accordingly.


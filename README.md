# NASA
REST Assured Groovy Framework for testing endpoints



Language: Java


Developer: Vik Sivakumar



Background: Using NASA's public API this framework tests status codes of endpoints, as well as the backend response for mentioned endpoints

1. Problem: How to Certify search endpoint? 
In order to certify the search endpoint, to start we want to validate the status code of the endpoint to verify if it returns a success code of 200.  Any other status code such as a 4xx or 5xx would indicate a sever side error. Having this as a first test identifies any underlying issues to begin with. 

Automating this test is crucial as manually verifying if the status code is time consuming, and if the status code is not a 200 then the rest of the tests that directly test the response/body of the endpoint should not trigger since initially the status code is a failure. 

As more endpoints are created it is essential to have a seperate API File which stores all the endpoints and named appropriately so that they can be called in individual test which correspond to the test case. 


Some unexpected issues that could occur could be identified around the authentication process for integrating to the current status of the endpoints. This will be further discussed. 


2. What is the best strategy to the test the authentication mechanism?

There is a clear difference between authentication and authorization. Authentication is where the credentials which are required to access the system are validated typically email/password combination and a "Agree to terms" condition. This will confirm the user's identity. Whereas authorization is where this will distinguish the users permission settings to determine which types of data are displayed to the user based on the authorization settings which are usually set by the Administrator. 

Tools used to test Authentiation: Postman is a ideal tool to test authentication especially with some /signin or /signout calls. If refresh tokens are necessary the tokens will be provided in the body after the header requests are satsified. Using the tool Postman we can save the token to use a "Bearer" token setting to continue hitting endpoints given we are testing a specific user directly from the server side. However if postman is not being used a CURL command to the terminal would also work. 

Blazemeter can be used to test/enforce number of API requests in a timebox setup. This can test the nunber of request that the sever can handle per given condition, this is necessary to know the maximum number to prevent crashes. 


A groovy framework is ideally the best approach given the situation. 

Test scenarios would include happy path tests which provide a correct/successful header request "email/password". Negative cases to determine if incorrect authentication headers are provided that the server returns a "Access Denied" message to the user to indicate they do not have authentication to proceed. Null entries is mandatory with authentication in that there are no header requests being sent therefore there should be an appopriate server side message indicating the header requests were given with null entries. 


Feature: Sim card activation
Checks whether the sim card has been activated by the sim card activator microservice.

Scenario: Functional sim card is active
Given a functional sim card
When a Post request is submitted to activate the card
Then the sim card is activated.

Scenario: Non functional sim cards are not active
Given a non functional sim card
When  a Post request is submitted to activate the card
Then the sim card is not activated.



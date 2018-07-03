Search loan in smava.com by Amount, duration and purpose

Meta:
@page smavaHome
@feature search

Narrative:

In order to show the loan detail selected
As a user
I want to search a loan by Amount, duration and purpose

Scenario: Loans Search by Amount, duration and purpose

Given The user navegates on smava
When The user selectes <amount>
And The user selectes <duration>
And The user selectes <purpose>
And The user presses the button next
Then the application is redirected to the result loan detail page

Examples:
|amount         |   duration    |   purpose     |
|2750           |   24          |   Wohnen      |
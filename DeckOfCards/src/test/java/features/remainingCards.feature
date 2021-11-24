Feature: Validate the remaining cards in the deck

Scenario: Remaining cards correctly updated after drawing

Given a new deck starts with 52 cards
When Draw cards from the deck 5 times each time draw between 1 and 5 cards at random
And Return the first drawn card back to the deck
Then Verify that the correct number of cards are remaining in the deck
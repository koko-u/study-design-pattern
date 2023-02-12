# Strategy Pattern

## class list

| name            | description                  |
|-----------------|------------------------------|
| Hand            | Rock-Paper-Scissors Hand     |
| Strategy        | Rock-Paper-Scissors Strategy |
| WinningStrategy | Play same Hand if win        |
| RandomStrategy  | Play random Hand             |
| Player          | Rock-Paper-Scissors player   |
| Main            |                              |

## class diagram

```plantuml
@startuml
class Player {
  -strategy: Strategy
  +nextHand(): Hand
  +match(other: Player): Result
}
interface Strategy {
  +nextHand(): Hand
  +study(hand: Hand, result: Result): void
}
class WinningStrategy
class RandomStrategy
interface Hand {
  +match(other: Hand): Result
}
class Rock
class Paper
class Scissors
interface Result
class Win
class Lose
class Draw

Player *- Strategy
Strategy <|.. WinningStrategy
Strategy <|.. RandomStrategy
Strategy -> Hand : create
Hand <|.. Rock
Hand <|.. Paper
Hand <|.. Scissors
Hand -> Result: result
Result <|.. Win
Result <|.. Lose
Result <|.. Draw

Player::match ..> Strategy::study
note on link : call study
@enduml
```

## 所感

# クラス一覧

| package   | name       | description                            |
|-----------|------------|----------------------------------------|
| pagemaker | Database   | get e-mail addresses from database     |
| pagemaker | HtmlWriter | create HTML file                       |
| pagemaker | PageMaker  | create THML file from e-mail addresses |

# クラス図

```plantuml
@startuml

class Main
class PageMaker
class HtmlWriter
class Database

Main -> PageMaker : use
PageMaker o-- HtmlWriter
PageMaker o-- Database
@enduml

```

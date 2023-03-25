# クラスとインターフェース一覧

| name        | description                                            |
|-------------|--------------------------------------------------------|
| Visitor     | the interface of visitor which visit file or directory |
| Element     | the interface of acceptor which accept a visitor       |
| ListVisitor | concrete visitor which list file and directories       |
| Entry       | the interface to identify files and directories        |
| File        | file class                                             |
| Directory   | directory class                                        |

# サンプルプログラムのクラス図

```plantuml
@startuml

interface Visitor {
  +visit(e: Element): void
}
note top of Visitor
訪れた Element の情報を参照して
自身で行うべき仕事を行う
end note

class ListVisitor {
}

Visitor <|.. ListVisitor

interface Element {
  +accept(v: Visitor): void
}

interface Entry {
  +name: String
  +size: Long
  +getIterator(): Iterator<Entry>
}
note right of Entry::getIterator
Visitor が往訪する順番は
Entry が知っている
end note

Element <|-- Entry : . Entry が訪問を受ける対象である

class File
class Directory {
  +add(e: Entry): Directory
}

Entry <|.. File
Entry <|.. Directory

Visitor -> Element : 往訪する

@enduml
```

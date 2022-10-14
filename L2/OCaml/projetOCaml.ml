type prop =
| Symb of string
| Top
| Bot
| Not of prop
| And of prop * prop
| Or of prop * prop
| Imp of prop * prop
| Equ of prop * prop;;


let f1 = Equ(And(Symb "a", Symb "b"), Or(Not(Symb "a"), Symb "b")) (*f1 = a∧b ⇔ ¬a∨b*)
let f2 = Or(Not(And(Symb "a", Not(Symb "b"))), Not(Imp(Symb "a", Symb "b"))) (*f2 = ¬(a∧¬b) ∨ ¬(a⇒b)*)
let f3 = And(Not(Imp(Symb "a", Or(Symb "a", Symb "b"))), Not(Not(And(Symb "a"), Or(Symb "b", Not(Symb "c"))))) (*f3 = ¬(a ⇒ a∨b) ∧ ¬¬(a∧(b∨¬c))*)
let f4 = And(And(And(And(And(Or(Or(Not(Symb "a"), Symb "b"), Symb "d")
		, Or(Not(Symb "d"), Symb "c"))
		, Or(Not(Symb "c"), Symb "b"))
		, Or(Not(Symbol "c"), Not(Symbol "b")))
		, Or(Not(Symb "b"), Symb "d")) (*f4 = (¬a∨b∨d) ∧ (¬d∨c) ∧ (c∨a) ∧ (¬c∨b) ∧ (¬c∨¬b) ∧ (¬b∨d)*)

let rec nbc fbf = function
| 
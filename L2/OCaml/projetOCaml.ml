type prop =
  | Symb of string
  | Top
  | Bot
  | Not of prop
  | And of prop * prop
  | Or of prop * prop
  | Imp of prop * prop
  | Equ of prop * prop
;; 

(* fonctions utiles *)
let rec egaliteListe l1 l2 = match l1 with
  |[] -> true
  |t::q -> (t == (List.hd l2)) && (egaliteListe q (List.tl l2))
;;


(* Q1 *)
let f1 = Equ(And(Symb "a", Symb "b"), Or(Not(Symb "a"), Symb "b"))
;; (* f1 = a∧b ⇔ ¬a∨b *) 
   
let f2 = Or(Not(And(Symb "a", Not(Symb "b"))), Not(Imp(Symb "a", Symb "b")))
;; (* f2 = ¬(a∧¬b) ∨ ¬(a⇒b) *)
   
let f3 = And(Not(Imp(Symb "a", Or(Symb "a", Symb "b"))), Not(Not(And(Symb "a", Or(Symb "b", Not(Symb "c"))))))
;; (* f3 = ¬(a ⇒ a∨b) ∧ ¬¬(a∧(b∨¬c)) *)
   
let f4 = And(And(And(And(And(Or(Or(Not(Symb "a"), Symb "b"), Symb "d")
                            , Or(Not(Symb "d"), Symb "c"))
                        , Or(Symb "c", Symb "a"))
                    , Or(Not(Symb "c"), Symb "b"))
                , Or(Not(Symb "c"), Not(Symb "b")))
            , Or(Not(Symb "b"), Symb "d"))
;; (* f4 = (¬a∨b∨d) ∧ (¬d∨c) ∧ (c∨a) ∧ (¬c∨b) ∧ (¬c∨¬b) ∧ (¬b∨d) *)



(* Q2 *)
let rec nbc = function
  | Top -> 0
  | Bot -> 0
  | Symb _ -> 0
  | Not a -> 1 + nbc a
  | And(a, b) -> 1 + nbc a + nbc b
  | Or(a, b) -> 1 + nbc a + nbc b
  | Imp(a, b) -> 1 + nbc a + nbc b
  | Equ(a, b) -> 1 + nbc a + nbc b
;;



(* Q3 *)
let prof = function
  | Top -> 0
  | Bot -> 0
  | Symb _ -> 0
  | Not a -> 1 + (nbc a)
  | And(a, b) -> 1 + max (nbc a) (nbc b)
  | Or(a, b) -> 1 + max (nbc a) (nbc b)
  | Imp(a, b) -> 1 + max (nbc a) (nbc b)
  | Equ(a, b) -> 1 + max (nbc a) (nbc b)
;;



(* Q4 *)
let rec count n li = match li with 
  | [] -> 0
  | t :: q when t = n -> 1 + (count n q)
  | t :: q -> count n q
;;



let rec supr_doublons = function
  | [] -> []
  | t::q when count t q = 0 -> t::supr_doublons q
  | _::q -> supr_doublons q
;;



let rec creer_li_var = function
  | Top -> []
  | Bot -> []
  | Symb a -> [a]
  | Not a ->  creer_li_var a
  | And(a,b) -> (creer_li_var a)@(creer_li_var b)
  | Or(a,b) -> (creer_li_var a)@(creer_li_var b)
  | Imp(a,b) -> (creer_li_var a)@(creer_li_var b)
  | Equ(a,b) -> (creer_li_var a)@(creer_li_var b) 
;;
  


let sp fbf = supr_doublons (creer_li_var fbf);;



(* Q5 *)
let rec afficheP = function
  | Symb a -> a
  | Top -> "⊤"
  | Bot -> "⊥" 
  | Not a -> "¬" ^ "(" ^  afficheP a ^ ")"
  | And(a, b) -> "(" ^ afficheP a ^ "∧" ^ afficheP b ^ ")"
  | Or(a, b) -> "(" ^ afficheP a ^ "∨" ^ afficheP b ^ ")"
  | Imp(a, b) -> "(" ^ afficheP a ^ "⇒" ^ afficheP b ^ ")"
  | Equ(a, b) -> "(" ^ afficheP a ^ "⇔" ^ afficheP b ^ ")"
;; 



(* Q6 *)
(* Equ(And(Symb "a", Symb "b"), Or(Not(Symb "a"), Symb "b")) *)
(* f1 = a∧b ⇔ ¬a∨b *) 
(*
  let rec affiche = function
    | Symb a -> a
    | Top -> "⊤"
    | Bot -> "⊥"
    | Not (Symb a) -> "¬" ^ a
    | Not a -> "¬" ^ "(" ^  affiche a ^ ")"
    | And(And(a, b), c) -> affiche a ^ "∧" ^ affiche b  ^ "∧" ^ affiche c
    | And(a, And(b, c)) -> affiche a ^ "∧" ^ affiche b  ^ "∧" ^ affiche c
    | And(Symb a, Symb b) -> a ^ "∧" ^ b
    | And(Symb a, b) -> a ^ "∧(" ^ affiche b ^ ")"
    | And(a, Symb b) -> "(" ^ affiche a ^ ")∧" ^ b
    | And(a, b) -> "(" ^ affiche a ^ ")∧(" ^ affiche b ^ ")"
    | Or(a, Or(b, c)) -> affiche a ^ "∨(" ^ affiche b  ^ "∨" ^ affiche c ^ ")"
    | Or(a, b) -> affiche a ^ "∨" ^ affiche b
    | Imp(Imp(a, b), c) -> "(" ^ affiche a  ^ "⇒" ^ affiche b ^ ")⇒" ^ affiche c
    | Imp(a, b) -> affiche a ^ "⇒" ^ affiche b 
    | Equ(a, Equ(b, c)) -> affiche a ^ "⇔(" ^ affiche b  ^ "⇔" ^ affiche c ^ ")"
    | Equ(a, b) -> affiche a ^ "⇔" ^ affiche b
  ;;
*)


(* Q7 *)
type valVerite = Zero | Un ;;

type interpretation = (string * valVerite) list;;

let i1 = [("a",Un) ; ("b",Zero) ; ("c",Un)];;

let i2 = [("a",Zero) ; ("b",Zero) ; ("c",Zero)];;

let i3 = [("a",Un) ; ("b",Un) ; ("c",Un)];;



(* Q8 *) 
let rec intSymb s = function
  |(symb,v)::q when symb = s -> v
  |_::q -> intSymb s q
;;
    
  

(* Q9 *) 
let intTop = Un
;;


let intBot = Zero
;;


let intNeg = function
  | Un -> Zero
  | Zero -> Un
;;


let intAnd v1 v2 = match v1 with
  | Un -> if (v2 == Un) then Un else Zero
  | _ -> Zero
;;


let intOr v1 v2 = match v1 with
  | Zero -> if (v2 == Zero) then Zero else Un
  | _ -> Un
;;


let intImp v1 v2 = match v1 with
  | Un -> if (v2 == Zero) then Zero else Un
  | _ -> Un
;;


let intEqu v1 v2 = match v1 with
  | Zero -> if (v2 == Zero) then Un else Zero
  | Un -> if (v2 == Un) then Un else Zero
;;



(* Q10 *)
let rec valV fbf i = match fbf with
  | Symb s -> intSymb s i
  | Top -> intTop
  | Bot -> intBot 
  | Not s -> intNeg (valV s i)
  | And (s1,s2) -> intAnd (valV s1 i) (valV s2 i)
  | Or (s1,s2) -> intOr (valV s1 i) (valV s2 i)
  | Imp (s1,s2) -> intImp (valV s1 i) (valV s2 i)
  | Equ (s1,s2) -> intEqu (valV s1 i) (valV s2 i)
;;



(* Q11 *)
let modele fbf i = (valV fbf i == Un)
;;



(* Q12 *)
(*  (string * valVerite) list list *)
let ensI1 = [[("p",Zero);("q",Zero)];[("p",Zero);("q",Un)];[("p",Un);("q",Zero)];[("p",Un);("q",Un)]]
;;



(* Q13 *)

let rec consTous v l = match l with
  | [] -> [[]]
  | t::q -> if (q != []) then (v::t)::(consTous v q) else [v::t]
;;


let rec ensInt (* ["b" ; "c"] *) = function
  | [] -> [[]]
  | t::q -> let q1 = ensInt q in (consTous (t,Un) q1) @ (consTous (t,Zero) q1)
;; 



(* Q14 *)
exception Modele of bool


let rec listeModele fbf i = match i with
  |[] -> []
  |t::q -> (modele fbf t)::(listeModele fbf q)
;;


let rec existeModele fbf i = match i with
  |[] -> raise (Modele false)
  |t::q -> if (modele fbf t) then raise (Modele true) else existeModele fbf q
;;

  

let satisfiable fbf = try existeModele fbf (ensInt (sp fbf)) with
  | Modele bool -> bool
;;

    
let satisfiable2 fbf = List.mem true (listeModele fbf (ensInt (sp fbf)))
;;



(* Q15 *)
let rec tousModele fbf i = match i with
  |[] -> raise (Modele true)
  |t::q -> if (not(modele fbf t)) then raise (Modele false) else existeModele fbf q
;;


let valide fbf = try tousModele fbf (ensInt (sp fbf)) with
  | Modele bool -> bool
;;

    
let valide2 fbf = not(List.mem false (listeModele fbf (ensInt (sp fbf))))
;;



(* Q16 *)
let insatisfiable fbf = not(satisfiable fbf)
;;


let insatisfiable2 fbf = not(satisfiable2 fbf)
;;



(* Q17 *)
let equivalent1 fbf1 fbf2 = egaliteListe (listeModele fbf1 (ensInt (sp fbf1))) (listeModele fbf2 (ensInt (sp fbf2)))
;;


let equivalent2 fbf1 fbf2 = valide (And(fbf1,fbf2))
;;



(* Q18 *)
let consequence2 fbf1 fbf2 = valide (* avec la 1, ne marche pas *) (Imp(fbf1,fbf2))
;;



(* Q19 *)
let rec tousSp = function
  | [] -> []
  | t::q -> supr_doublons ((sp t)@(tousSp q))
;;



let rec modeleCommun ensFbf i = function
  | [] -> true
  | t::q -> (modele t i) && (modeleCommun q i)
;;











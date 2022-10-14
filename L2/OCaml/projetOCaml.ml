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
let rec affiche = function
  | Symb a -> "a"
  | Top -> "⊤"
  | Bot -> "⊥" 
  | Not a -> "¬" ^ "(" ^  affiche a ^ ")"
  | And(a, b) -> "(" ^ affiche a ^ "∧" ^ affiche b ^ ")"
  | Or(a, b) -> "(" ^ affiche a ^ "∨" ^ affiche b ^ ")"
  | Imp(a, b) -> "(" ^ affiche a ^ "⇒" ^ affiche b ^ ")"
  | Equ(a, b) -> "(" ^ affiche a ^ "⇔" ^ affiche b ^ ")"
;;



(* Q6 *)

(* Q7 *)
type valVerite = Zero | Un ;;

type interpretation = (string * valVerite) list;;

let i1 = [("a",Un) ; ("b",Zero) ; ("c",Un)];;

let i2 = [("a",Zero) ; ("b",Zero) ; ("c",Zero)];;

let i3 = [("a",Un) ; ("b",Un) ; ("c",Un)];;



(* Q8 *) 
let rec intSymb s i = match i with
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


let intAnd s2 = function
  | Un -> if (s2 == Un) then Un else Zero
  | _ -> Zero
;;


let rec intOr s2 = function
  | Zero -> if (s2 == Zero) then Zero else Un
  | _ -> Un
;;


let rec intImp s2 = function
  | Un -> if (s2 == Zero) then Zero else Un
  | _ -> Un
;;


let rec intEqu s2 = function
  | Zero -> if (s2 == Zero) then Un else Zero
  | Un -> if (s2 == Un) then Un else Zero
;;



(* Q10 *)
let rec valV fbf i = match fbf with
  | Top -> intTop
  | Bot -> intBot
  | Symb s -> intSymb s i
  | Not s -> intNeg (valV s i)
  | And (s1,s2) -> intAnd (valV s1 i) (valV s2 i)
  | Or (s1,s2) -> intOr (valV s1 i) (valV s2 i)
  | Imp (s1,s2) -> intImp (valV s1 i) (valV s2 i)
  | Equ (s1,s2) -> intEqu (valV s1 i) (valV s2 i)
;;



(* Q11 *)
let rec modele fbf i = if (valV fbf i == Un) then true else false
;;



(* Q12 *)

    
    


    


    
    
    
    
    
    
    
    
    


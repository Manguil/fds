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
let rec intNeg s i = if(intSymb s i == Zero) then Un else Zero 
;;


let intAnd s1 s2 i = if(intSymb s1 i == Un && intSymb == Un) then Un else Zero
;;


let rec intOr s1 s2 i = if (intSymb s1 i == Un || intSymb s2 i == Un) then Un else Zero
;;


let rec intImp s1 s2 i = if (Not (intSymb s1 i == Un) || intSymb s2 i == 1) then Un else Zero
;;


let rec intEqu s1 s2 i = if (intSymb s1 i == intSymb s2 i) then Un else Zero
;;



(* Q10 *)
let rec valV fbf i = match fbf with
  |Top -> intTop
  |Bot -> intBot
  |Symb a -> intSymb a i
  |Not a
    


    

    
    


    


    
    
    
    
    
    
    
    
    


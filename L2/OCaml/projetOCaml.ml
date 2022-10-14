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

let I1 = [("a",Un) ; ("b",Zero) ; ("c",Un)];;

let I2 = [("a",Zero) ; ("b",Zero) ; ("c",Zero)];;

let I3 = [("a",Un) ; ("b",Un) ; ("c",Un)];;
syms x
format long

f(x) = (x^3-x-3);
p = [1 0 -1 -3];

racine = roots(p)

fzero(f,1)
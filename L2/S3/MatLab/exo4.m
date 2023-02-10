subplot(2,1,1)
syms x y
f(x,y) = sqrt(abs(x.*y));
fsurf(f, [-5 5 -5 5])

subplot(2,1,2)
syms x
g(x) = 3*x^2+1+(log((x-pi)^2))./pi^4;
fplot(g, [pi-0.01 pi+0.01])
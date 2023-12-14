% d'après wolframe alpha, elle vaut environ 0.47725.

a=0; b=1;
f=@(x) exp(-x^2/2)/sqrt(2*pi);
h=(b-a)/3;
x=a:h:b;
Iftrap=h/2*sum(f(x(1:end-1))+f(x(2:end)))
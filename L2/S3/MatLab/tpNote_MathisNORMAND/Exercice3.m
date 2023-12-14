x = [1 3 5 8 10];
y = [2.25 4.3 8 17.5 27];

interp1(x,y,6)
%
%

subplot(2,1,1);
title('comparaison point d interpolation et polynome d hermite');
u = linspace(1,10,5);
interpolation = polyfit(x,y,4);
hermite =  pchip(x,y,u)
plot(x,interpolation)
hold on
plot(x,hermite)

subplot(2,1,2);
title('comparaison point d interpolation et polynome de lagrange');
interpolation = polyfit(x,y,4);
lagrange = polyval(interpolation,% le polynome de lagrange est de degrée 4
plot(x,interpolation)
hold on
plot(lagrange,x)
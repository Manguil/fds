format long
a=4+0.0001-4;  %le premier cas est moins precis car moins proche de zero
b=4-4+0.0001;

x = 1.0e+29;
y = 1.0e-9;
x1=((y+x)-x)/y; %le premier cas est moins precis car on additionne deux  nombres de puissance très differente
y1=(y+(x-x))/y;

c=10^309/9.9^309; %le premier cas depasse le realmax
d=(10/9.9)^309;
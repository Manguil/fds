format long

f = @(x) exp(x) + 3 * sqrt(x) - 2;
a = 0;
b = 1;

fplot(f,[a,b])

epsilon = 10(-10);
while b-a > epsilon
m = (a + b)/2
if f(a) * f(m)<0
    b = m
else
    a = m
end
end
a
b


f = @(x) (x - 0.5 * sin(x) - 1);
epsilon=10(-10);
x(1) = 1;
k = 1;
while not(f(x(k) - epsilon) <= 0 & f(x(k) + epsilon) >= 0)
    x(k+1) = 1 + 0.5 * sin(x(k))
    k = k + 1;
end
x
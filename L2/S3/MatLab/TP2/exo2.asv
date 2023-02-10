format long
a=1;b=2;
f=@(x)(x-(1/2)*sin(x)-1);
epsilon=10^(-8);
while b-a>epsilon
    m=(a+b)/2;
    if f(a)*f(m)<0
        b=(a+b)/2;
    else
        a=(a+b)/2;
    end
end
a
b

%_____________________________________________________%

deriveef=@(x)(1-0.5*cos(x));
a=1;b=2;
x(1)=2;
e=b-a;
k=1;
while e>epsilon
    x(k+1)=x(k)-f(x(k))/deriveef(x(k));
    e=abs(x(k+1)-x(k));
    if k>2
        y(k-2)=abs(x(k-1)-x(k))/abs(x(k-2)-x(k-1));
        z(k-2)=abs(x(k-1)-x(k))/abs(x(k-2)-x(k-1))^2;
    end
    k=k+1;
end
x
y
z

%_____________________________________________________%



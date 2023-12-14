format long

f = @(x) sqrt(x+1) - sqrt(x)
g = @(x) 1 ./ (sqrt(x+1) + sqrt(x))

y = 10:20
x = 10.^y

f(x) % ans =

   %1.0e-05 *

  %Columns 1 through 6

   %0.499999441672117   0.158115290105343   0.050000380724669   0.015785917639732   0.005029141902924   0.001862645149231

  %Columns 7 through 11

  %                 0                   0                   0
  %                 0                   0  on obtient 0 car car la
  %                 difference entre les deux nombres est trop faible.

g(x) % ans = 

   %1.0e-05 *

  %Columns 1 through 6

   %0.499999999987500   0.158113883008024   0.049999999999987   0.015811388300842   0.005000000000000   0.001581138830084

  %Columns 7 through 11

   %0.000500000000000   0.000158113883008   0.000050000000000   0.000015811388301   0.000005000000000
   
   
   
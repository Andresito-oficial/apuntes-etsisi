% representación gráfica de líneas de campo y superficies equipotenciales

% datos
k=9*10^9; % constante de Coulomb
x0=-0.5; % posición x carga
y0=0; % posición y carga

q=input('valor de la carga en nC, q: ');
q0=q*10^-9; % valor carga en C

a=-1.0:0.2:2.0;
b=-1.0:0.1:1.0;
[x,y]=meshgrid(a,b);

r0=abs(sqrt((x-x0).^2+(y-y0).^2)); % módulo del vector posición
fx=k*(q0*(x-x0)./r0.^3); % componente x del campo eléctrico
fy=k*(q0*(y-y0)./r0.^3); % componente y del campo eléctrico

V= k*q0./r0; %Valor del potencial

f1=figure;
quiver(x,y,fx,fy,2,'r'); % dibujo las líneas del campo vectorial
hold on
contour(x,y,V, 40); % Dibujo de las líneas equipotenciales
xlabel('x (m)')
ylabel('y (m)')
title('potencial y campo por Coulomb')
hold off

[ex ey]=gradient(-V,0.2,0.1); % campo como gradiente del potencial
f2=figure;
quiver(x,y,ex,ey,1,'r') % dibujo las líneas del campo vectorial
hold on
contour(x,y,V,40); % Dibujo de las líneas equipotenciales
xlabel('x (m)')
ylabel('y (m)')
title('potencial y campo por gradiente')
hold off

% problema base de movimiento de partículas cargadas en campos eléctricos
% datos
v0=3.4*10^6; % velocidad inicial en x (m)
d=0.045; % distancia (m) en presencia de campo eléctrico
E=520; % campo eléctrico (N/C)
q=-1.61*10^(-19); % carga eléctrica del electrón (C)
m=9.11*10^(-31); % masa del electrón (kg)
a=q*E/m;%aceleración en la dirección del campo eléctrico
tc=d/v0; % tiempo total en presencia de campo eléctrico
n=input('número de pasos, n: ');
dt=tc/n; %incremento de tiempo en cada paso
i=0:n;
t=dt*i;
x=v0*dt*i;
y=a*((dt.^2)*(i.^2))/2;
plot(x,y,'r')
xlabel('x (m)')
ylabel('y (m)')
grid on
title('trayectoria x(y)')
y1=a*(tc^2)/2; %componente y posición de salida en m
y1
vx1=v0; % componente x de la velocidad de salida en m/s
vx1
vy1=a*tc;% componente y de la velocidad de salida en m/s
vy1
alfa=atan(vy1/vx1); %ángulo de salida en radianes
angulo=alfa*180/pi;
angulo % ángulo de salida en grados


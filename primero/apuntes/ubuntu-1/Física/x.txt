% problema base de movimiento de partículas cargadas en 
% campos eléctricos

% datos
v0=3.4*10^6; % velocidad inicial en x (m)
d1=0.045; % distancia (m) en presencia de campo eléctrico
E1=520; % campo eléctrico (N/C)
q=-1.61*10^(-19); % carga eléctrica del electrón (C)
m=9.11*10^(-31); % masa del electrón (kg)

a1=q*E1/m;%aceleración en la dirección del campo eléctrico
tc1=d1/v0; % tiempo total en presencia de campo eléctrico

n=100;
dt1=tc1/n; %incremento de tiempo en cada paso
i=0:n;
t1=dt1*i;
x01=v0*dt1*i;
y01=a1*((dt1.^2)*(i.^2))/2;

plot(x01,y01,'r')
xlabel('x (m)')
ylabel('y (m)')
grid on
title('trayectoria x(y)')

y1=a1*(tc1^2)/2; %componente y posición de salida en m
y1
vx1=v0; % componente x de la velocidad de salida en m/s
vx1
vy1=a1*tc1;% componente y de la velocidad de salida en m/s
vy1
alfa1=atan(vy1/vx1); %ángulo de salida en radianes
angulo1=alfa1*180/pi;
angulo1 % ángulo de salida en grados

hold on

distancia2=0.09;
CampoElectrico2=-520;

aceleracion2=q*CampoElectrico2/m;
tiempoTotal2=distancia2/v0;

incrementoTiempo2=tiempoTotal2/n;

j=0:n;
tiempo2=incrementoTiempo2*j;
x02=(v0*incrementoTiempo2*j)+d1;
y02=(y1+(vy1*(incrementoTiempo2*j)))+(aceleracion2*((incrementoTiempo2.^2)*(j.^2))/2);

plot(x02,y02,'r')
grid on

y2=(y1+(vy1*tiempoTotal2))+((aceleracion2*(tiempoTotal2^2))/2);
y2
vx2=v0;
vx2
vy2=vy1+(aceleracion2*tiempoTotal2);
vy2
alfa2=atan(vy2/vx2);
angulo2=alfa2*180/pi;
angulo2

hold on

distancia3=0.09;
CampoElectrico3=520;

aceleracion3=q*CampoElectrico3/m;
tiempoTotal3=distancia3/v0;

incrementoTiempo3=tiempoTotal3/n;

l=0:n;
tiempo3=incrementoTiempo3*l;
x03=(v0*incrementoTiempo3*l)+d1+distancia2;
y03=(y2+(vy2*(incrementoTiempo3*l)))+(aceleracion3*((incrementoTiempo3.^2)*(l.^2))/2);

plot(x03,y03,'r')
grid on

y3=(y2+(vy2*tiempoTotal3))+((aceleracion3*(tiempoTotal3^2))/2);
y3
vx3=v0;
vx3
vy3=vy2+(aceleracion3*tiempoTotal3);
vy3
alfa3=atan(vy3/vx3);
angulo3=alfa3*180/pi;
angulo3

hold on

distancia4=0.09;
CampoElectrico4=-520;

aceleracion4=q*CampoElectrico4/m;
tiempoTotal4=distancia4/v0;

incrementoTiempo4=tiempoTotal4/n;

p=0:n;
tiempo4=incrementoTiempo4*p;
x04=(v0*incrementoTiempo4*p)+d1+distancia2+distancia3;
y04=(y3+(vy3*(incrementoTiempo4*p)))+(aceleracion4*((incrementoTiempo4.^2)*(p.^2))/2);

plot(x04,y04,'r')
grid on

y4=(y3+(vy3*tiempoTotal4))+((aceleracion4*(tiempoTotal4^2))/2);
y4
vx4=v0;
vx4
vy4=vy3+(aceleracion4*tiempoTotal4);
vy4
alfa4=atan(vy4/vx4);
angulo4=alfa4*180/pi;
angulo4

hold off
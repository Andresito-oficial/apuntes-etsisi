% REGLA DE LOS TRAPECIOS
% integración numérica campo eléctrico para calcular ddp
% introducir datos
a=input('extremo inferior de integración:');
b=input('extremo superior de integración:');
n=input('número de intervalos:');
% Definimos el vector x:
x = linspace(a,b,n+1);
% Definimos el campo eléctrico creado por un anillo
% de carga con kQ=60Nm^2/C y R=1m según ecuación (1)
campo = @(x) (60*x)./(((x.^2)+1).^1.5);
% potencial (valor exacto según ecuación (2)):
potencial = @(x) 60./(((x.^2)+1).^0.5);
%diferencia de potencial exacta
ddp_exacta=potencial(b)-potencial(a);
ddp_exacta;
% función que vamos a integrar numéricamente
y = campo(x);
% Realizamos la integración por trapecios
ddp_aprox =-trapz(x,y);
ddp_aprox;
% trapz es una función de matlab que calcula por el método de trapecios el área
% bajo la curva y=campo(x)

% Dibujamos el área bajo la curva
fig = figure; fig.Color = "w";
grid on % la cuadrícula
plot(linspace(a,b,100),campo(linspace(a,b,100)),"r","linewidth",2);
% la función campo eléctrico
hold on
plot(linspace(a,b,100),potencial(linspace(a,b,100)),"g","linewidth",2);
% el potencial (exacto)
hold on
xlabel('x') % etiquetamos el eje X
ylabel('E, V') % etiquetamos el eje Y
title("Integración por trapecios:ddp"); % ponemos título
% Dibujamos los trapecios de integración y rellenamos el área uno a uno
for i = 1:numel(x)-1
if mod(i,2)==0
c = 'b';
else
c = 'w';
end
area(x(i:i+1),y(i:i+1),"FaceColor",c,"FaceAlpha",0.15);
end
% la función de matlab ‘area’ rellena áreas bajo curvas
hold off
% Ponemos la leyenda
s1 = sprintf("$area$, n = %d",n);
legend("$campo$","$potencial$",s1,"FontSize",11,"Interpreter","latex")
% Mostramos el valor numérico (aproximado) de la integral (la ddp entra a y b)
% definimos las coordenadas x e y dónde aparecerá el texto
% mostramos el valor aproximado de la integral
xt=(a+b)/2; yt=(potencial(b)+potencial(a))/2;text(xt,yt,"$ddp_{aprox}\approx$ "+ num2str(ddp_aprox,5)+"$ V $","Interpreter","Latex","FontSize",14);
% num2str convierte números en array de caracteres

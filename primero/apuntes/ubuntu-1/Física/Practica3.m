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
campo = @(x) (60.*x)./(((x.^2)+1).^1.5);
% potencial (valor exacto según ecuación (2)):
potencial = @(x) 60./(((x.^2)+1).^0.5);
%diferencia de potencial exacta
ddp_exacta=potencial(b)-potencial(a);
ddp_exacta
% función que vamos a integrar
y = campo(x);
% Realizamos la integración por trapecios
v_aprox =-trapz(x,y); % trapz es una función de matlab que calcula por el método de trapecios el área bajo la curva y=campo(x)

% Dibujamos el área bajo la curva
fig = figure;
%fig.Color = "w";
grid on % la cuadrícula
plot(linspace(a,b,200),campo(linspace(a,b,200)),"r","linewidth",2); % la función campo eléctrico
hold on
plot(linspace(a,b,200),potencial(linspace(a,b,200)),"g",
"linewidth",2); % el potencial (exacto)
hold on
xlabel('x') % etiquetamos el eje X
ylabel('E, V') % etiquetamos el eje Y
title("Integración por trapecios"); % ponemos título
% Dibujamos los trapecios de integración y rellenamos el área uno a uno
for i = 1:numel(x)-1
area(x(i:i+1),y(i:i+1),"FaceColor","b","FaceAlpha",0.15)
% la función de matlab ‘area’ rellena áreas bajo curvas
end
text(x(1),-0.1,"a","FontSize",15)
text(x(end),-0.1,"b","FontSize",15)
hold off
% Ponemos la leyenda
s1 = sprintf("$area$, n = %d",n);
legend("$campo$","$potencial$",
s1,"FontSize",11,"Interpreter","latex")
% Mostramos el valor numérico (aproximado) de la integral (la ddp entra a y b)
xt=(a+b)/2; yt=(potencial(b)+potencial(a))/2;
% definimos las coordenadas x e y dónde aparecerá el texto
text(xt,yt, "$ddp_{ba}\approx$ " + num2str(ddp_aprox,5)+
"$ V (aprox)$", "Interpreter","Latex","FontSize",14) %num2str convierte números en array de caracteres

function T = tabulatedData
    % datos de un campo desconocido (aquí son la función seno)
    col1 = [0 0.05 0.1 0.15 0.2 0.25 0.3 0.35 0.4 0.45
    0.5 0.55 0.6 0.65 0.7 0.75 0.8 0.85 0.9 0.95 1 1.1 1.2
    1.3 1.4 1.5 1.6 1.7 1.8 1.9 2]';
    col2 = [0.904673 0.732028 0.50591 0.252999 -0.000003
    -0.228929 -0.414208 -0.542303 -0.606422 -0.606531 -0.606531 -0.54871 -0.443995 -0.306847 -0.153448 0.000005
    0.138855 0.251233 0.328925 0.367814 0.367879 0.269295
    0.093069 -0.084222 -0.199504 -0.22313 -0.163335 -0.056448 0.051084 0.121006 0.135335]';
T = table(col1,col2,'VariableNames',{'x','y'});
end

%leemos los datos de la tabla
T =tabulatedData;
% dibujamos los datos
plot(T.x,T.y,"ko")
xlabel("x")
ylabel("y")
grid on
hold on
set(gca,"XAxisLocation","origin","XTick",0:0.25:3)
% identificamos nuestros datos x,y
x = T.x;
y = T.y;
% cálculo de la integral I (la ddp)
I = 0; % inicializamos una variable
n = numel(x); % número de puntos del dataset
for i = 1:(n-1)
I = I +(x(i+1) - x(i))*0.5*(y(i) + y(i+1));
area(x(i:i+1),y(i:i+1),"FaceColor","y","FaceAlpha",0.34)
end
hold off
% Mostrar el resultado
text(x(end)-2,2,"$ddp_{ab}\approx$ " +
num2str(I,4)+"$ V$","Interpreter","Latex","FontSize",14)
fprintf("ddp = %2.5f",I)
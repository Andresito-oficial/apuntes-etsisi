% Problema base de movimiento de partículas cargadas en campos eléctricos
% Datos
v0 = 3.4 * 10^6; % velocidad inicial en x (m/s)
d = 315; % distancia total (m)
E0 = 520; % magnitud del campo eléctrico (N/C)
q = -1.61 * 10^(-19); % carga eléctrica del electrón (C)
m = 9.11 * 10^(-31); % masa del electrón (kg)

% Definir el campo eléctrico en función de x
E = @(x) E0 * ( (x >= 0 & x <= 45) - (x > 45 & x <= 135) + (x > 135 & x <= 225) - (x > 225 & x <= 315) );

% Aceleración en función de x
a = @(x) q * E(x) / m;

% Condiciones iniciales
x0 = 0; % posición inicial en x (m)
y0 = 0; % posición inicial en y (m)
vx0 = v0; % velocidad inicial en x (m/s)
vy0 = 0; % velocidad inicial en y (m/s)

% Parámetros de simulación
n = input('Número de pasos, n: '); % número de pasos
dt = d / (v0 * n); % incremento de tiempo en cada paso

% Inicialización de variables
i = 0:n;
t = dt * i;
x = zeros(1, n+1);
y = zeros(1, n+1);
vx = zeros(1, n+1);
vy = zeros(1, n+1);

x(1) = x0;
y(1) = y0;
vx(1) = vx0;
vy(1) = vy0;

% Integración numérica usando el método de Euler
for k = 1:n
    % Actualizar velocidad en y
    vy(k+1) = vy(k) + a(x(k)) * dt;
    
    % Actualizar posición en x e y
    x(k+1) = x(k) + vx(k) * dt;
    y(k+1) = y(k) + vy(k+1) * dt;
    
    % Velocidad en x es constante (no hay aceleración en x)
    vx(k+1) = vx(k);
end

% Gráfica de la trayectoria
figure;
plot(x, y, 'r', 'LineWidth', 1.5);
xlabel('x (m)');
ylabel('y (m)');
grid on;
title('Trayectoria de la partícula en el campo eléctrico variable');

% Resultados finales
y_final = y(end); % posición final en y (m)
vx_final = vx(end); % velocidad final en x (m/s)
vy_final = vy(end); % velocidad final en y (m/s)

fprintf('Posición final en y: %.4f m\n', y_final);
fprintf('Velocidad final en x: %.4f m/s\n', vx_final);
fprintf('Velocidad final en y: %.4f m/s\n', vy_final);

% Ángulo de salida
alfa = atan(vy_final / vx_final); % ángulo en radianes
angulo = alfa * 180 / pi; % ángulo en grados
fprintf('Ángulo de salida: %.4f grados\n', angulo);
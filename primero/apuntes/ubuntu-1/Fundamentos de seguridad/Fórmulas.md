Cifrado afín:
$$
C_i = a \times M_i + b\bmod n
$$
$$
M_i = \left( C_i -b\right) \times a^{-1}\bmod n
$$
Cifrado con decimación pura:
$$
C_i = a \times M_i \bmod n
$$
$$
M_i = a^{-1} \times C_i \bmod n
$$
Cifrado por desplazamiento puro:
$$
C_i = \left( M_i + b \right) \bmod n
$$
$$
M_i = \left( C_i - b \right) \bmod n
$$
$$
M_i = \left( C_i + n - b \right) \bmod n
$$
Cifrado de Hill:
$$
C = \left( K \times M \right) \bmod n
$$
Ataque de Kasiski:
Se calcula Longitud posible = mcd ( <lista de las separaciones> ).
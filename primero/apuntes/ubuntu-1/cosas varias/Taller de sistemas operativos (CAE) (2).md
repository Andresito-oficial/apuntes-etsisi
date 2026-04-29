

Esto sirve como CAE por ahora

---
##### Comandos sesion1:
- `pwd` : saber en que fichero estas
- `cd` : moverte entre ficheros
	- `cd ..` : atrás
	- `cd tso` : moverte al fichero tso (Relativo)
	- `cd /xd/alumnos/tal/` : moverte a tal (absoluto)
- `ls -l` : mostrar lo que hay en un fichero
- `cat` : Mirar lo de un fichero (ma o meno, es otra cosa pero no lo entiendo)
- `echo` : Repite lo que escribas.
	- `echo *` : el `*` es un carácter especial y se usa con echo.
	- `echo m*` : ficheros con m al inicio.
	- `echo *m` : fichero con m al final.
	- `echo *s*` : ficheros que contengan s (NO SELECCIONA LOS QUE EMPIEZAN O TERMINAN por s).
	- `echo palabras/*s` : Hace lo de `*s` pero en el fichero palabras.
	- `echo */*s` : hace lo se `*s` pero en todos los ficheros que estén dentro del fichero actual.
	- `echo [aeiou]*[aeiou] `: todo lo que empiece y termine por vocal.
	Echo saca lo que le pidas en orden alfabético
- `grep` : buscar dentro de un fichero.
	- `grep 'r' meses` : sacar todo lo que tenga r.
	- `grep 'r' *s` saca todo lo que contenga r de los ficheros que terminan en s.
- Sacar de un fichero algo y mandarlo a otro:
	- `grep dias > con-r`
- `head -2 meses` : lee de meses pero solo los dos primeros.
- `tail -2 meses` : lee de meses pero solo los dos últimos.
- `ctr D` : Finaliza.
- `wc`: tamaño del fichero

Anotaciones:
Las comillas son un carácter especial y sirve para que el cmd entienda tu comando de manera literal. Ej: `echo 's'` te devuelve s, no busca s.
También son caracteres especiales `* , ? , [] , [^]`

---
##### Comandos sesion2:
Como hacer un programa.
- `bash pripro.sh` : Interpreta un programa (creo). El `sh` indica que es un programa sel
- `echo "tail -2 meses" > pripro.sh` : añade una acción.
  `echo "head -2 meses" >> pripro.sh` : añade otra.
  `cat pripro.sh`: mira lo que hay dentro, que es lo anterior.
  `bash pripro.sh`: ejecuta el programa:
  `ctr D` : salir.
- `vi f`
	  Orden/comando
	  - `:q` : salir
	  - `:wq`: guarda y sale
	  - `:q!`: forzar sin guardar salida
	  - `flecha abajo / arriba / derecha / izquierda`: Moverse por las líneas
	  - `931G` : ir a la línea 931.
	  - `dd` : borrar línea
	  - `x` :borrar el carácter en el que este el cursor
	  Inserción
	 -  `i`  : insertar donde esta el cursor
	 - `A` :  Inicio de la línea.
-  `ls -R`
- `ls -l pripro.sh` : info del fichero (ej numero de caracteres)
- `touch`: cambiar fecha de modificación del fichero
	  - `touch fno` : pone la fecha actual
- 


Ejemplos:
 `bash pripro.sh colores 1`: ejecutar el script 1 en colores (creo)

---

##### Comandos sesión 3:

Expresiones regulares:
  *Clásicas (`^, $, [], [^], a*, ., .*`)*
  *Modernas*
  *Marcadas (` \( \) `)*

`#`: comentarios en Shell
`?` = sirve para representar un carácter cualquiera. En esa posición vale cualquier carácter

^  == al principio  // $ == al final  //  `[]` == conjunto de cosas  //  a* o aa*  o x* == no cadena (espacio nulo entre caracteres)  //  .* == Es para poner varias ¿condiciones? (no se como explicarlo, ver ejemplo)  //  (` \( \) ` : se explica en el ejemplo de 10.
-  `grep '^e' meses` : líneas con e al inicio.
-  `grep 'e$' meses `: líneas con e al final.
- `grep '^$' meses` : líneas vacías.
- `grep '^[aeiou]' meses` : que empiecen por vocal.
- `grep '^[^aeiou]' meses` : que no comiencen por aeiou.
- `grep '[^aeiou].$' meses` : El último carácter puede ser cualquiera pero el segundo no puede ser vocal.
- `grep '^[aeiou].*[aeiou]$' meses` : Terminan y empiezan por vocal.
- `grep -v '[be]' meses` : Complementario al comando. Saca todo lo que no cumpla el comando.
-  `grep 'b.*e' meses` : que tenga una b y luego una e en algún punto.
- `grep '^\([aeiou]\).*\1$' meses` : Comiencen y terminen por la misma vocal. Lo que se halla seleccionado al inicio se hace referencia al final con un `\1`.
- `grep '^\([0-9]\)\([0-9]\)\2\1$' meses` : busca números capicuas pero si los numeros preporcionados son de 4 dijitos
- `grep '\([aeiou]\).*\1.*\1' meses` : 3 veces con la misma vocal

Se ponen comentarios con # y se pone ; para varios comandos de seguido (ej: `cd .. ; cd palabras`)

En cuanto a ficheros. Los ficheros tienen nombre y i-nodo (a parte del contenido dentro del fichero). El i-nodo es la info del fichero que guarda cosas como ultima fecha de modificación, donde esta la info en el disco... entre otras cosas.

`cp` == copiar fihero (contenido del fichero)
	`cp dias-new`
`mv` == cambiar el nombre del fichero ej: `mv dias-new dias-old`
`rm` == borrar ficheros ej: `rm dias-old`
`ln` == crea un fichero que te lleva al contenido de otro fichero(descripción corta: es un acceso directo). ej: `ln dias dias.ln` siendo dias.ln el aceso directo.
Si se escribe luego `cat dias.ln` también aparecerá tso como una línea
mkdir : crea carpetas
rm -r : borrar todo

`time mv f1 f2`: Para saber cuando tarda una acción en ejecutarse.

ls:
- -x: permiso de ejecucion
- -m: permiso de escritura en el directorio padre.

Ejemplos de cosas y cosas ramdom:
`grep --color 'e' meses` : pone de colorinchis las e que a detectado.
`grep ^'a' meses` : La primera línea que empiece por a

---

##### Comandos sesión 4:

**Metacaracteres**:
Los ficheros que empiezan por . no aparecerán si escribes `echo *`. Se debe escribir `echo .*` para que aparezcan. Con `ls -la` aparece info sobre ellos. 
.. representa el directorio anterior y  . el directorio actual
- `echo .[^.]*` : nombres de ficheros o directorios que empiezan por punto y que el segundo carácter no sea un punto.

**Acotado**:
Con `''` todos los metacaracteres pierden sus "poderes".
- `echo '*'` saca un `*`. Pero escribir `echo ''*''` no sacará hará lo mismo porque son dos pares de comillas con nada dentro
- si no cierras las comillas el "enter" también pierde sus poderes hasta que se ponga otra comilla simple
Con `""` hace lo mismo pero `$ \ y otro que el profe no quiere explicar` no pierden sus poderes. Por ejemplo con una variable i="hola" solo se puede llamar con `echo $i`. Ej `echo "$HOME"`.
- `echo "'$HOME'"` : en este caso las comillas le quita el poder a las simples y si `echo '"$HOME"'` las comillas simple le quitan el poder a todo.
Con `\` (acotado puntual) quita el poder al siguiente carácter si tiene poder.
- `echo \*` : devuelve `*`.
- `echo "\$HOME"` : la barra quita el poder del $ porque `\` no es afectada por las `""`
- `echo \\*` : muestra los ficheros que empiecen por `\`.
- `echo ?\**` : muestra los ficheros que tengan un `*` en el segundo carácter.
- `echo \\\**` : ficheros que empiecen con `\*`.

**Los Filtros**:
Los filtros ¿cosas? que no se procesan y que filtran la info.(ej: `tail, cat, head`).
Estos son algunos:
- `tac` : da la vuelta al fichero. primera línea = última
- `rev` : muestra cada línea al revés. (`abcd > dcba`)
- `sort` : ordena en modo ascendente alfabético.
	- `sort -n num` : Ordenación numérica.
	- `sort -n -r num` : Ordenación numérica reversa.
- `uniq` : elimina donde halla líneas idénticas consecutivas deja solo un ejemplar.
	- `cat uniq votos` : solo sacaría eliminaría los si y no que se repitan dos o más veces de seguido y si haces  `cat uniq -c votos` si hay varias líneas repetidas las pone como una y con el numero de veces que se repite de seguido. Con `sort votos > v` y `uniq -c v` para que todos los repetidos salgan de seguido, se eliminen los repetidos y se cuenten.
- `cut` : (Explicado de manera simple: corta en columnas :D (corta en columnas si pones -c))
	- `cut -c1` : primer carácter de cada línea. -c para indicar que es por columnas.
	- `cut -c2,4 días` : 2º y 4º carácter.
	- `cut -c4- dias` : desde el 4º hasta el final.
- `wc` : cuenta las palabras. 
	- `wc dias`: dará las líneas, palabras y caracteres en ese orden. Si solo quieres alguno de los 3 puedes añadir -l -w -c respectivamente. `wc` cuenta el salto de línea como carácter.

**Tuberías** `|`:
Sirven para comunicar. Comunican procesos emparentados (de padre común)
- `sort votos | uniq -c | sort -rn` : Este es un ejemplo anterior de este día pero con esto no se necesita crear un fichero nuevo.
`|` "hace todo a la vez" Todo se maneja en la memoria y se ejecuta en paralelo, ya que los comandos de la tubería pueden estar activos simultáneamente. Por lo que si el primer filtro (en el caso anterior) es más rápido que los demás cuando este se llene( de 1 a 10k de "espacio") se parará. Si el último es más rápido se parará (esto último no lo tengo claro).
- `rev dias | sort | rev` : ordena días al revés con `sort` y los vuelve a dar la vuelta. 

---

##### Comandos sesión 5:

**Repaso filtros**:
- `sort -KKK 2> err`: Salida de error mandar a err.
- `sort num` ; `sort <num` ; `cat num|sort` hacen lo mismo. El 2º y 3º son muy parecidos en comparación al 1º. Estos dos usan 3 descriptores de ficheros (el mínimo para existir), no tienen que abrir el fichero al contrario que el 1º. 

**Filtro Paste**:
Junta (o pega) dos ficheros por columnas. Si se juntan dos ficheros la primera línea tienen la primera línea del primer fichero y luego la línea del siguiente fichero.
- `paste -d: meses dias` : junta meses y días separado por un :.
El delimitador`-d:` sirve para cambiar la separación entre columnas. Sin delimitador, el delimitador por defecto es el Tab.
- `paste -d'' meses dias`: lo mismo pero sin separación.
- `cat dias |paste meses` : solo sale meses (días ni aparece) porque no hace nada con la entrada estándar (que sería lo de `cad`).
- `cat dias| paste meses -` : ahora si que aparece días. el `-` sirve para decirle paste donde debe estar lo de la entrada estándar. Igual al revés  `cat dias| paste meses -`.
Esto último sirve para todo. `echo "Hola| cat - meses"` funcionaria de manera similar.
- `cat dias| paste - meses -`: hace algo raro de pelotas. Ocurre algo así:
	`lunes enero martes`
	`miercoles febrero jueves` …
- `cat dias| paste -d'' - - - - - - -`: otro ejemplo poco relevante.

**Filtro cut**:
Lo de cortar y tal. Ya se explico en la sesión anterior.
`more /etc/pasage` : Esto es poco importante pero es necesario saber que esto es una carpeta muy grande que tiene el sistema.
- `cut -d: -f /etc/passed| more` : Coge solo el nombre de esta carpeta.
- `grep '^bv0' /etc/passed \ cut -d: -f5 | cut -d: -f5 | cut-d' ' -f1 |  sed 'y/ÁÉÍÓÚ/AEIOU/ | sort | uniq -c | sort -rn | head -10` : esto filtra los solo los nombres. Sin apellidos o segundos nombres. Aparecen ordenados y solo una vez. También aparecen el numero de gente con ese nombre. Y hace el top de los 10 más comunes. El `ÁÉÍ...` es poco importante ya que no lo hemos dado.

**Filtro Comm**:
Es un conjunto de 3 operaciones: `A-B, B-A, A Ualrever B`. Solo admite dos ficheros.
- `com marinos mamiferos`: hace 3 columnas, una para marinos, otra para mamíferos y otra de ambos.
- `com -12 marinos mamiferos`:  quita la 1º y 2º columna. Se puede poner -23 o -13 y quitaría sus respectivas columnas.

**Filtro Join**:
Solo admite dos ficheros ordenados con un campo común.  Producto cartesiano dos ficheros(o algo así).
- `join empleados departamentos` : junta ambos ficheros(mirar foto móvil para ver ejemplo).
- `join -o 1.1 1.2 2.1 empleados departamento` : Hace lo mismo pero saca, del primer fichero el primero y segundo campo y del segundo el primer campo.

---


#Principal 
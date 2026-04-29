; APARTADO 4.1.3
;   Suma de dos vectores de tamaño BYTE, dejando el resultado en un tercero.

; Dirección de comienzo de las variables
.data
.org 0x200

vectorA:	.byte  0, 1, 2, 3, 4, 5, 6, 7  ; char vectorA[] = {0,1,2,3,4,5,6,7}
vectorB:	.byte  1, 1, 1, 1, 1, 1, 1, 1  ; char vectorB[] = {1,1,1,1,1,1,1,1}
vectorSum:  .space 8					   ; char vectorSum[8]
; El simulador WinMIPS no permite dar a las constantes un nombre (etiqueta),
; lo que obliga a utilizar la constante (8) en el código
;  Dirección de comienzo del código
.text
.org 0x0

MAIN: daddi r1,r0,0 ; i=0
FOR:  slti r2,r1,8 ; for (i=0; i<8; i++) {
      beqz r2,FIN ; ................
      lb r2,vectorA(r1) ; r2=vectorA[i]
      lb r3,vectorB(r1) ; r3=vectorB [i]
      dadd r4,r2,r3 ; vectorSum[i]=vectorA[i]+ vectorB[i]
      sb r4,vectorSum(r1) ; ........
      daddi r1,r1,1 ; }
      j FOR
FIN:  halt

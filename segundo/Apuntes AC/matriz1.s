.data
.org 0x200
; La matriz es de 2x2 con elementos de tamaño 1 octeto
FILS: .byte 2
COLS: .byte 2
; MATRIZ tiene un tamaño de FILS*COLS*1 octetos
MATRIZ: .space 4
.text
.org 0x0
MAIN: daddi r1,r0,1 ; r1 = 1 (i)
daddi r2,r0,2 ; r2 = 2 (j)
lbu r10,FILS(r0) ; r10 = FILS
dmulu r3,r1,r10 ; r3 = i * FILS + j
daddu r3,r3,r2 ; .........
lb r4,MATRIZ(r3) ; r4 = MATRIZ[1][2]

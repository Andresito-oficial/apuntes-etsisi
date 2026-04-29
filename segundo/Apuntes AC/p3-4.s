.data
i:      .word32 0
suma:   .word32 0
array:  .space  960
        .code
main:
    ; Inicializar los elementos del array con el valor 2
    lw      r2,         i(r0)
    daddi   r3,         r0,             240
    daddi   r6,         r0,             2
FOR_LOOP_1:
    slt     r4,         r2,             r3
    dsll    r5,         r2,             2
    beqz    r4,         END_FOR_LOOP1
    sw      r6,         array(r5)
    daddi   r2,         r2,             1
    j       FOR_LOOP_1
    nop
END_FOR_LOOP1:
    ; Recorre el bucle suma += array[i]^2
    daddi   r2,         r0,             0   ; i=0 en r2
    daddi   r3,         r0,             240 ; tamaño=240 en r3
    lw      r5,         suma(r0)            ; suma en r5
    slt     r4,         r2,             r3
    dsll    r6,         r2,             2
FOR_LOOP_2:
    beqz    r4,         END_FOR_LOOP2
    lw      r7,         array(r6)
    daddi r9, r6, 4
    dmul    r8,         r7,             r7  ; a[i]*a[i]
    lw r10, array(r9)
    daddi r12, r9, 4
    dmul r11, r10, r10
    lw r13, array(r12)
    daddi r15, r12, 4
    dmul r14, r13, r13
    lw r16, array(r15)
    daddi   r2,         r2,             4
    dmul r17, r16, r16
    dadd    r5,         r5,             r8
    slt     r4,         r2,             r3
    dadd r5, r5, r11
    dsll    r6,         r2,             2
    dadd r5, r5, r14
    dadd r5, r5, r17
    j       FOR_LOOP_2
    nop
END_FOR_LOOP2:
    sw      r5,         suma(r0)
    sw      r2,         i(r0)
    halt

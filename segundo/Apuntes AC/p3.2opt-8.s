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
FOR_LOOP_2:
    slt     r4,         r2,             r3
    dsll    r6,         r2,             2
    beqz    r4,         END_FOR_LOOP2
    lw      r7,         array(r6)
    daddi r2, r2, 1
    dsll r9, r2, 2
    lw r10, array(r9)
    daddi r2, r2, 1
    dsll r12, r2, 2
    lw r13, array(r12)
    daddi r2, r2, 1
    dsll r15, r2, 2
    lw r16, array(r15)
    daddi r2, r2, 1
    dsll r18, r2, 2
    lw r19, array(r18)
    daddi r2, r2, 1
    dsll r21, r2, 2
    lw r22, array(r21)
    daddi r2, r2, 1
    dsll r24, r2, 2
    lw r25, array(r24)
    daddi r2, r2, 1
    dsll r27, r2, 2
    lw r28, array(r27)
    dmul    r8,         r7,             r7  ; a[i]*a[i]
    dmul r11, r10, r10
    dmul r14, r13, r13
    dmul r17, r16, r16
    dmul r20, r19, r19
    dmul r23, r22, r22
    dmul r26, r25, r25
    dmul r29, r28, r28
    dadd    r5,         r5,             r8
    dadd r5, r5, r11
    dadd r5, r5, r14
    dadd r5, r5, r17
    dadd r5, r5, r20
    dadd r5, r5, r23
    dadd r5, r5, r26
    dadd r5, r5, r29
    daddi   r2,         r2,             1
    j       FOR_LOOP_2
    nop
END_FOR_LOOP2:
    sw      r5,         suma(r0)
    halt

; Dirección de comienzo de las variables
.data
.org ……………………
vector: ……………………………
.org ……………………
MAX: .space 1
MIN: .space 1
; Dirección de comienzo del código
.text
.org ……………………………………
MAIN: daddi r1,r0,8 ; i = 8
DOWHILE: lbu r10,MIN(r0) ; { r10 = MAX
lbu r11,MAX(r0) ; r11 = MIN
daddi r1,r1,-1 ; i = i - 1
lb r2,VECTOR(r1) ; r2 = vector[i]
slt r5,r2,r10 ; if (vector[i] < MIN)
beqz r5,ES_MAYOR ; …………………………
sb r2,MIN(r0) ; MIN = vector[i]
ES_MAYOR: ………………………………………………… ; if (vector[i] > MAX)
slt r5,r2,r11
beqz r5,CONT ; …………………………
sb r2,MAX(r0) ; MAX = vector[i]
CONT: bnez r1,DOWHILE ; } do while (i > 0)
halt

; ejecutar sin "delay slot"
.data
vector: .word32 1,2,3,4,5,6,7,8
.code
daddi r1,r0,0
daddi r2,r0,32 ; Tamaño del vector en bytes
loop: lw r10,vector(r1)
daddi r10,r10,4 ; Tamaño de cada elemento
sw r10,0(r1)
daddi r1,r1,4
bne r1,r2,loop
halt

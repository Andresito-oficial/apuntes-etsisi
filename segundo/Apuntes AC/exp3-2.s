	.data
	.org	0xD0
vector: .word32	1,2,3,4,5,6,0

	.text
	daddi	R1,R0,0
etq:	lw	R2,vector(R1)
	daddi	R3,R1,4
	beqz	R2,fin
	lw	R4,vector(R3)
	dmul	R2,R2,R2
	dmul	R4,R4,R4
	sw	R2,vector(R1)
	sw	R4,vector(R3)
	daddi	R1,R1,8
	j	etq
fin:	halt

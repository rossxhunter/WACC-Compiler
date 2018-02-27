.text
.global main
f_isDigit:
PUSH {lr}
MOV r0, r4
POP {pc}
POP {pc}
.ltorg
main:
PUSH {lr}
SUB sp, sp, #1
MOV r4, #0
STRB r4, [sp]
MOV r4, #1
STRB r4, [sp]
ADD sp, sp, #1
LDR r0, =0
POP {pc}
.ltorg

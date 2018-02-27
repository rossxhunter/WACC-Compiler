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
LDR r0, =0
POP {pc}
.ltorg

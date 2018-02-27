.data
msg_0:
.word 1
.ascii "\0"
.text
.global main
main:
PUSH {lr}
BL p_print_ln
LDR r0, =0
POP {pc}
.ltorg
p_print_ln:
PUSH {lr}
LDR r0, =msg_0
ADD r0, r0, #4
BL puts
MOV r0, #0
BL fflush
POP {pc}

.data
msg_3:
.word 1
.ascii "\0"
msg_1:
.word 5
.ascii "%.*s "
msg_0:
.word 25
.ascii "Please input an integer: "
msg_2:
.word 11
.ascii "You input: "
.text
.global main
main:
PUSH {lr}
SUB sp, sp, #4
LDR r4, =0
STR r4, [sp]
LDR r5, =msg_0
MOV r0, r5
BL p_print_string
LDR r6, =msg_2
MOV r0, r6
BL p_print_string
BL p_print_ln
ADD sp, sp, #4
LDR r0, =0
POP {pc}
.ltorg
p_print_string:
PUSH {lr}
LDR r1, [r0]
ADD r2, r0, #4
LDR r0, =msg_1
ADD r0, r0, #4
BL printf
MOV r0, #0
BL fflush
POP {pc}
p_print_ln:
PUSH {lr}
LDR r0, =msg_3
ADD r0, r0, #4
BL puts
MOV r0, #0
BL fflush
POP {pc}

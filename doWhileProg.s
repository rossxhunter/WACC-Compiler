.data
msg_0:
.word 2
.ascii "HI"
msg_1:
.word 5
.ascii "%.*s\0"
msg_2:
.word 82
.ascii "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\n"
msg_3:
.word 2
.ascii "HI"
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
SUB sp, sp, #4
LDR r4, =0
STR r4, [sp]
LDR r4, =msg_0
MOV r0, r4
BL p_print_string
LDR r4, [sp]
LDR r5, =1
ADDS r4, r4, r5
BLVS p_throw_overflow_error
STR r4, [sp]
B L0
L1:
LDR r4, =msg_3
MOV r0, r4
BL p_print_string
LDR r4, [sp]
LDR r5, =1
ADDS r4, r4, r5
BLVS p_throw_overflow_error
STR r4, [sp]
L0:
LDR r4, [sp]
LDR r5, =5
CMP r4, r5
MOVLT r4, #1
MOVGE r4, #0
CMP r4, #1
BEQ L1
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
p_throw_overflow_error:
LDR r0, =msg_2
BL p_throw_runtime_error
p_throw_runtime_error:
BL p_print_string
MOV r0, #-1
BL exit

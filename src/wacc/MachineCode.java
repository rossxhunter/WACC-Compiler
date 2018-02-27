package wacc;

import java.util.*;

/**
 * Created by Ross on 18/11/2017.
 */
public class MachineCode {

  private static MachineCode instance = new MachineCode();

  private List<String> lines = new ArrayList<>();
  private Stack<String> registers = new Stack<>();
  private List<String> ioFuncs = new ArrayList<>();
  private List<String> msgs = new ArrayList<>();
  private Map<Integer, String> insert = new LinkedHashMap<>();
  private Map<String, Integer> vars = new LinkedHashMap<>();
  private int stackRes = 0;
  private int msgNum = 0;
  private int branchNum = 0;
  private int lastScopePointer = 0;
  private int scopePointer = 0;
  private int numOfVarsCurrent = 0;
  private int numOfVarsPrev = 0;
  private boolean printMsg = false;
  private boolean printlnMsg = false;
  private boolean printIntMsg = false;
  private boolean printBoolMsg = false;
  private boolean printRefMsg = false;
  private boolean overflowErrorMsg = false;
  private boolean runtimeErrorMsg = false;
  private boolean divideByZeroMsg = false;
  private boolean nullRefMsg = false;
  private boolean readIntMsg = false;
  private boolean readCharMsg = false;
  private boolean freePairMsg = false;

  private MachineCode() {
    lines.add(".text");
    lines.add(".global main");
    lines.add("main:");
    lines.add("PUSH {lr}");

    for (int i = 11; i > 3; i--) {
      registers.add("r" + i);
    }

    lastScopePointer = lines.size();
    scopePointer = lastScopePointer;
  }

  public static MachineCode getInstance() {
    return instance;
  }

  public void add(String s) {
    lines.add(s);

  }

  public void removeLast() {
    lines.remove(lines.size() - 1);
  }

  public String getLines() {
    String programLines = "";

    if (msgNum > 0) {
      programLines += ".data" + '\n';
    }

    for (String msg: msgs) {
      programLines += msg + '\n';
    }

    for (String line : lines) {
      programLines += line + '\n';
    }

    programLines += "LDR r0, =0" + '\n';
    programLines += "POP {pc}" + '\n';
    programLines += ".ltorg" + '\n';

    for (String func : ioFuncs) {
      programLines += func + '\n';
    }

    return programLines;
  }

  public String getReg() {
    if(!registers.empty()){
      return registers.pop();
    } else {
      lines.add("PUSH {10}");
      registers.push("r10");
      return registers.pop();
    }

  }

  public boolean isRegstackEmpty() {
    return registers.empty();
  }

  public void freeReg(String reg) {
    registers.push(reg);
  }

  public void reserveStack(int i) {
    stackRes += i;
  }

  public void freeStack() {
    if (stackRes != 0) {
      int lineOffset = 0;
      int currStackRes = stackRes;

      if (stackRes > 1024) {
        lines.add(scopePointer, "SUB sp, sp, #" + 1024);
        currStackRes = stackRes - 1024;
        lineOffset++;
      }


      for (int key: insert.keySet()) {
        lines.add(key + lineOffset, insert.get(key));
        lineOffset++;
      }

      lines.add(scopePointer, "SUB sp, sp, #" + currStackRes);

      if (stackRes > 1024) {
        lines.add("ADD sp, sp, #" + 1024);
      }

      lines.add("ADD sp, sp, #" + currStackRes);
      stackRes = 0;
      scopePointer = lastScopePointer;
      numOfVarsCurrent = numOfVarsPrev;
    }

  }

  public int getMsgNum() {
    return msgNum;
  }

  public void incMsgNum() {
    msgNum++;
  }

  public void genPrintString() {
    if (!printMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 5" + '\n';
      msg += ".ascii \"%.*s\\0\"";
      msgs.add(msg);

      String printFun = "";
      printFun += "p_print_string:" + '\n';
      printFun += "PUSH {lr}" + '\n';
      printFun += "LDR r1, [r0]" + '\n';
      printFun += "ADD r2, r0, #4" + '\n';
      printFun += "LDR r0, =msg_" + i + '\n';
      printFun += "ADD r0, r0, #4" + '\n';
      printFun += "BL printf" + '\n';
      printFun += "MOV r0, #0" + '\n';
      printFun += "BL fflush" + '\n';
      printFun += "POP {pc}";

      ioFuncs.add(printFun);
      msgNum++;
      printMsg = true;
    }
  }

  public void genPrintlnString() {
    if (!printlnMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 1" + '\n';
      msg += ".ascii \"\\0\"";
      msgs.add(msg);

      String printlnFunc = "";
      printlnFunc += "p_print_ln:" + '\n';
      printlnFunc += "PUSH {lr}" + '\n';
      printlnFunc += "LDR r0, =msg_" + i + '\n';
      printlnFunc += "ADD r0, r0, #4" + '\n';
      printlnFunc += "BL puts" + '\n';
      printlnFunc += "MOV r0, #0" + '\n';
      printlnFunc += "BL fflush" + '\n';
      printlnFunc += "POP {pc}";

      msgNum++;
      ioFuncs.add(printlnFunc);
      printlnMsg = true;
    }
  }

  public void genPrintIntString() {
    if (!printIntMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 3" + '\n';
      msg += ".ascii \"%d\\0\"";
      msgs.add(msg);

      String printIntFunc = "";
      printIntFunc += "p_print_int:" + '\n';
      printIntFunc += "PUSH {lr}" + '\n';
      printIntFunc += "MOV r1, r0" + '\n';
      printIntFunc += "LDR r0, =msg_" + i + '\n';
      printIntFunc += "ADD r0, r0, #4" + '\n';
      printIntFunc += "BL printf" + '\n';
      printIntFunc += "MOV r0, #0" + '\n';
      printIntFunc += "BL fflush" + '\n';
      printIntFunc += "POP {pc}";

      msgNum++;
      ioFuncs.add(printIntFunc);
      printIntMsg = true;
    }
  }

  public void genPrintBoolString() {
    if (!printBoolMsg) {
      int i = msgNum;
      int j = msgNum + 1;

      String msg1 = "";
      msg1 += "msg_" + i + ":" + '\n';
      msg1 += ".word 5" + '\n';
      msg1 += ".ascii \"true\\0\"";
      msgs.add(msg1);

      String msg2 = "";
      msg2 += "msg_" + j + ":" + '\n';
      msg2 += ".word 6" + '\n';
      msg2 += ".ascii \"false\\0\"";
      msgs.add(msg2);

      String printFun = "";
      printFun += "p_print_bool:" + '\n';
      printFun += "PUSH {lr}" + '\n';
      printFun += "CMP r0, #0" + '\n';
      printFun += "LDRNE r0, =msg_" + i + '\n';
      printFun += "LDREQ r0, =msg_" + j + '\n';
      printFun += "ADD r0, r0, #4" + '\n';
      printFun += "BL printf" + '\n';
      printFun += "MOV r0, #0" + '\n';
      printFun += "BL fflush" + '\n';
      printFun += "POP {pc}";

      msgNum++;
      msgNum++;
      ioFuncs.add(printFun);
      printBoolMsg = true;
    }
  }

  public void genPrintRefString() {
    if(!printRefMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 3" + '\n';
      msg += ".ascii \"%p\\0\"";
      msgs.add(msg);

      String printRefFunc = "";
      printRefFunc += "p_print_reference:" + '\n';
      printRefFunc += "PUSH {lr}" + '\n';
      printRefFunc += "MOV r1, r0" + '\n';
      printRefFunc += "LDR r0, =msg_" + i + '\n';
      printRefFunc += "ADD r0, r0, #4" + '\n';
      printRefFunc += "BL printf" + '\n';
      printRefFunc += "MOV r0, #0" + '\n';
      printRefFunc += "BL fflush" + '\n';
      printRefFunc += "POP {pc}";

      msgNum++;
      ioFuncs.add(printRefFunc);
      printRefMsg = true;
    }
  }

  public void genOverflowErrorString() {
    if (!overflowErrorMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 82" + '\n';
      msg += ".ascii \"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"";
      msgs.add(msg);

      String overflowErrFunc = "";
      overflowErrFunc += "p_throw_overflow_error:" + '\n';
      overflowErrFunc += "LDR r0, =msg_" + i + '\n';
      overflowErrFunc += "BL p_throw_runtime_error";

      msgNum++;
      ioFuncs.add(overflowErrFunc);
      overflowErrorMsg = true;
      genRuntimeErrorString();
    }
  }

  public void genRuntimeErrorString() {
    if (!runtimeErrorMsg) {

      String runtimeErrFunc = "";
      runtimeErrFunc += "p_throw_runtime_error:" + '\n';
      runtimeErrFunc += "BL p_print_string" + '\n';
      runtimeErrFunc += "MOV r0, #-1" + '\n';
      runtimeErrFunc += "BL exit";

      ioFuncs.add(runtimeErrFunc);
      runtimeErrorMsg = true;
      genPrintString();
    }
  }

  public void genDivideByZeroString() {
    if (!divideByZeroMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 45" + '\n';
      msg += ".ascii \"DivideByZeroError: divide or modulo by zero\\n\\0\"";
      msgs.add(msg);

      String divideByZeroFunc = "";
      divideByZeroFunc += "p_check_divide_by_zero:" + '\n';
      divideByZeroFunc += "PUSH {lr}" + '\n';
      divideByZeroFunc += "CMP r1, #0" + '\n';
      divideByZeroFunc += "LDREQ r0, =msg_" + i + '\n';
      divideByZeroFunc += "BLEQ p_throw_runtime_error" + '\n';
      divideByZeroFunc += "POP {pc}";

      msgNum++;
      ioFuncs.add(divideByZeroFunc);
      divideByZeroMsg = true;
      genRuntimeErrorString();
    }
  }

  public void genReadIntString() {
    if(!readIntMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 3" + '\n';
      msg += ".ascii \"%d\\0\"";
      msgs.add(msg);

      String readIntFunc = "";
      readIntFunc += "p_read_int:" + '\n';
      readIntFunc += "PUSH {lr}" + '\n';
      readIntFunc += "MOV r1, r0" + '\n';
      readIntFunc += "LDR r0, =msg_" + i + '\n';
      readIntFunc += "ADD r0, r0, #4" + '\n';
      readIntFunc += "BL scanf" + '\n';
      readIntFunc += "POP {pc}";

      msgNum++;
      ioFuncs.add(readIntFunc);
      readIntMsg = true;
    }
  }

  public void genReadCharString() {
    if(!readCharMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 4" + '\n';
      msg += ".ascii \"%c\\0\"";
      msgs.add(msg);

      String readCharFunc = "";
      readCharFunc += "p_read_char:" + '\n';
      readCharFunc += "PUSH {lr}" + '\n';
      readCharFunc += "MOV r1, r0" + '\n';
      readCharFunc += "LDR r0, =msg_" + i + '\n';
      readCharFunc += "ADD r0, r0, #4" + '\n';
      readCharFunc += "BL scanf" + '\n';
      readCharFunc += "POP {pc}";

      msgNum++;
      ioFuncs.add(readCharFunc);
      readCharMsg = true;
    }
  }

  public void genNullRefString() {
    if (!nullRefMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 50" + '\n';
      msg += ".ascii \"NullReferenceError: dereference a null reference\\n\\0\"";
      msgs.add(msg);

      String checkNullPointer = "";
      checkNullPointer += "p_check_null_pointer:" + '\n';
      checkNullPointer += "push {lr}" + '\n';
      checkNullPointer += "CMP r0, #0" + '\n';
      checkNullPointer += "LDREQ r0, =msg_" + i + '\n';
      checkNullPointer += "BLEQ p_throw_runtime_error" + '\n';
      checkNullPointer += "POP {pc}";

      msgNum++;
      ioFuncs.add(checkNullPointer);
      nullRefMsg = true;
      genRuntimeErrorString();
    }
  }

  public void genFreePairString() {
    if(!freePairMsg) {
      int i = msgNum;

      String msg = "";
      msg += "msg_" + msgNum + ":" + '\n';
      msg += ".word 50" + '\n';
      msg += ".ascii \"NullReferenceError: dereference a null reference\\n\\0\"";
      msgs.add(msg);

      String freePairFunc = "";
      freePairFunc += "p_free_pair:" + '\n';
      freePairFunc += "PUSH {lr}" + '\n';
      freePairFunc += "CMP r0, #0" + '\n';
      freePairFunc += "LDREQ r0, =msg_" + i + '\n';
      freePairFunc += "BEQ p_throw_runtime_error" + '\n';
      freePairFunc += "PUSH {r0}" + '\n';
      freePairFunc += "LDR r0, [r0]" + '\n';
      freePairFunc += "BL free" + '\n';
      freePairFunc += "LDR r0, [sp]" + '\n';
      freePairFunc += "LDR r0, [r0, #4]" + '\n';
      freePairFunc += "BL free" + '\n';
      freePairFunc += "POP {r0}" + '\n';
      freePairFunc += "BL free" + '\n';
      freePairFunc += "POP {pc}";

      msgNum++;
      ioFuncs.add(freePairFunc);
      freePairMsg = true;
      genRuntimeErrorString();
    }
  }

  public void addMsg(String msg) {
    msgs.add(msg);
  }

  public void enterScopePointer() {
    lastScopePointer = scopePointer;
    scopePointer = lines.size();
    numOfVarsPrev = numOfVarsCurrent;
    numOfVarsCurrent = 0;
  }


  public void addInsert(String s) {
    insert.put(lines.size(), s);
  }

  public void updateInsert() {
    String temp;
    int i = insert.keySet().size();
    int j = stackRes / i;
    int z = 1;

    for (int key: insert.keySet()) {
      temp = insert.get(key);
      if (numOfVarsCurrent == 1 || (stackRes - (j * z) == 0)) {
        temp += "[sp]";
      } else {
        temp += "[sp, #" + (stackRes - (j * z)) + "]";
      }
      insert.replace(key, temp);
      z++;
      i--;
    }
  }

  public int getInsertSize() {
    return insert.keySet().size();
  }

  public int getBranchNum() {
    return branchNum;
  }

  public void incBranchNum() {
    branchNum++;
  }

  public int getNumOfVars() {
    return numOfVarsCurrent;
  }

  public void incNumOfVars() {
    numOfVarsCurrent++;
  }

  public void addVars(String s) {
    vars.put(s, numOfVarsCurrent);
  }

  public int getVarNum(String s){
    return vars.get(s);
  }

}

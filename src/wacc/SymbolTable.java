package wacc;

import wacc.IdentifierObjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private SymbolTable encSymTable;
    private Map<String, IDENTIFIER> dict;

    public SymbolTable(SymbolTable st) {
         dict = new HashMap<>();
         encSymTable = st;
    }

    public SymbolTable getEncSymTable() {
        return encSymTable;
    }

    public void add(String name, IDENTIFIER obj) {
        dict.put(name, obj);
    }

    public IDENTIFIER lookup(String name) {
        return dict.get(name);
    }

    public IDENTIFIER lookupAll(String name){
        SymbolTable S = this;
        while (S != null) {
            IDENTIFIER obj = S.lookup(name);
            if (obj != null) {
                return obj;
            }
            S = S.getEncSymTable();
        }
        return null;
    }

    public List<String> getAll() {
        List<String> s = new ArrayList<>();
        for(String a : dict.keySet()) {
            s.add(a);
        }
        return s;
    }

}

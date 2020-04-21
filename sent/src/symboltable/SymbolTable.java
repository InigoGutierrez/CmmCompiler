package symboltable;

import java.util.*;
import ast.defs.Definition;

public class SymbolTable {

	private int scope=0;
	private List<Map<String,Definition>> table;

	public SymbolTable()  {
	    table = new ArrayList<>();
	    table.add(new HashMap<>());
	}

	public void set() {
		scope++;
		table.add(new HashMap<>());
	}

	public void reset() {
	    if (scope >= 0) {
			table.remove(scope);
			scope--;
		}
	}

	public boolean insert(Definition definition) {
		if (existsInScope(scope, definition.getName())) {
			return false;
		}
		definition.setScope(scope);
		table.get(scope).put(definition.getName(), definition);
		return true;
	}

	public Definition find(String id) {
	    for ( int i = scope; i >= 0; i-- ) {
			if (existsInScope(i, id))
				return table.get(i).get(id);
		}
	    return null;
	}

	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}

	private boolean existsInScope(int scope, String id) {
		return table.get(scope).containsKey(id);
	}
}


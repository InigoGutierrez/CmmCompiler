# DLP Lab 10 notes

How to get address of a global variable:

&global = Σnob(type(prev vars not incl itslf))
&local = BP-Σnob(type(prev vars incl itslf))
&param = BP+4+Σnob(type(prev vars not incl itslf))
&recField (offset) = Σnob(type(prev fields not incl itself))

How to compute and annotate these values? Which visit method should do it?

global: VarDefinition
local: VarDefinition
param: VarDefinition (the one in the args of FunctionType)
recField: RecordField

Also, Type now has nob()

visit(FunctionDefinition, param) could compute the offset of params.
With this approach, VarDef computes only local and global variables, which is
able to distinguish because of their scope attribute.

The compiler can't know the value of BP; it is for dynamic memory.


Doubts:

- How to accumulate the offset? Traversing?
- AbstractCGVisitor? Is it useful now?
  - No


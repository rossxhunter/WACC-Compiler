// Generated from ./WACCParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WACCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WACCParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WACCParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(@NotNull WACCParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#arrayElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem(@NotNull WACCParser.ArrayElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#assignRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignRHS(@NotNull WACCParser.AssignRHSContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(@NotNull WACCParser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#assignLHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignLHS(@NotNull WACCParser.AssignLHSContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#unaryOper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOper(@NotNull WACCParser.UnaryOperContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(@NotNull WACCParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull WACCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(@NotNull WACCParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull WACCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(@NotNull WACCParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#boolOper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOper(@NotNull WACCParser.BoolOperContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#arrayLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLit(@NotNull WACCParser.ArrayLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#println}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln(@NotNull WACCParser.PrintlnContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull WACCParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#boolLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLit(@NotNull WACCParser.BoolLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#intLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLit(@NotNull WACCParser.IntLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(@NotNull WACCParser.EndContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull WACCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull WACCParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#free}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFree(@NotNull WACCParser.FreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#pairElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElem(@NotNull WACCParser.PairElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull WACCParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(@NotNull WACCParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull WACCParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#ord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrd(@NotNull WACCParser.OrdContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#intSign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntSign(@NotNull WACCParser.IntSignContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#pairLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairLit(@NotNull WACCParser.PairLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull WACCParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull WACCParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(@NotNull WACCParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#newPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewPair(@NotNull WACCParser.NewPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#charLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLit(@NotNull WACCParser.CharLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#pairType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairType(@NotNull WACCParser.PairTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#pairElemType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemType(@NotNull WACCParser.PairElemTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#binaryOp1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp1(@NotNull WACCParser.BinaryOp1Context ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(@NotNull WACCParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#binaryOp2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOp2(@NotNull WACCParser.BinaryOp2Context ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#exit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExit(@NotNull WACCParser.ExitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(@NotNull WACCParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#strLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLit(@NotNull WACCParser.StrLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull WACCParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(@NotNull WACCParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#compareOper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOper(@NotNull WACCParser.CompareOperContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#statFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatFunc(@NotNull WACCParser.StatFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#begin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin(@NotNull WACCParser.BeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull WACCParser.AssignContext ctx);
}
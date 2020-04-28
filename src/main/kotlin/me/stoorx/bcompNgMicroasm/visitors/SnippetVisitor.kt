package me.stoorx.bcompNgMicroasm.visitors

import me.stoorx.bcompNgMicroasm.ast.SnippetElement
import me.stoorx.bcompNgMicroasm.ast.ValveContainer
import me.stoorx.bcompNgMicroasm.elements.Valve
import me.stoorx.bcompNgMicroasm.gen.MicroasmParser
import me.stoorx.bcompNgMicroasm.gen.MicroasmParserBaseVisitor
import me.stoorx.bcompNgMicroasm.helpers.VisitorHelpers
import org.antlr.v4.runtime.tree.TerminalNode

class SnippetVisitor : MicroasmParserBaseVisitor<Any>() {
    val snippets = LinkedHashMap<String, SnippetElement>()

    override fun visitSnippetStatement(ctx: MicroasmParser.SnippetStatementContext?): SnippetElement {
        val name = ctx?.IdLiteral()?.symbol?.text ?: throw Exception("Snippet name error")
        val valves = this.visitOmcOperandList(ctx.omcOperandList())
        return SnippetElement(name, valves).also { snippets[name] = it }
    }

    override fun visitOmcOperandList(ctx: MicroasmParser.OmcOperandListContext?): List<ValveContainer> {
        val valves = ArrayList<ValveContainer>()

        ctx?.omcOperandList()
            ?.let { this.visitOmcOperandList(it) }
            ?.also { valves.addAll(it) }

        ctx?.omcOperand()
            ?.let { this.visitOmcOperand(it) }
            ?.also { valves.add(it) }

        return valves
    }

    override fun visitOmcOperand(ctx: MicroasmParser.OmcOperandContext?): ValveContainer {
        val literal = ctx?.valveLiteral()
        val snippetId = ctx?.IdLiteral()
        if (literal != null) {
            return this.visitValveLiteral(literal)
        }
        if (snippetId != null) {
            return snippets.getOrElse(snippetId.text) {
                throw Exception(
                    "Error at ${snippetId.symbol.line}:${snippetId.symbol.charPositionInLine}: Undeclared snippet ${snippetId.text}"
                )
            }
        }
        throw Exception("Incorrect OMC operand")
    }

    override fun visitValveLiteral(ctx: MicroasmParser.ValveLiteralContext?): Valve {
        return VisitorHelpers.valveTokenToValve((ctx?.children?.first() as TerminalNode).symbol)
    }
}
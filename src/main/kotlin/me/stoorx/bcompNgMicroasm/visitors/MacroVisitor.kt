package me.stoorx.bcompNgMicroasm.visitors

import me.stoorx.bcompNgMicroasm.ast.SnippetElement
import me.stoorx.bcompNgMicroasm.gen.MicroasmParser
import me.stoorx.bcompNgMicroasm.gen.MicroasmParserBaseVisitor

class MacroVisitor(
    private val snippets: Map<String, SnippetElement>
) : MicroasmParserBaseVisitor<Any>() {
    override fun visitMacroStatememnt(ctx: MicroasmParser.MacroStatememntContext?): Any {
        val name = ctx?.IdLiteral()?.text ?: throw Exception("Macro name error")
        val mcStatementsList = this.visitMicrocommandStatementList(ctx.microcommandStatementList())
        return super.visitMacroStatememnt(ctx)
    }
}
package me.stoorx.bcompNgMicroasm

import me.stoorx.bcompNgMicroasm.gen.MicroasmLexer
import me.stoorx.bcompNgMicroasm.gen.MicroasmParser
import me.stoorx.bcompNgMicroasm.visitors.SnippetVisitor
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

fun main(args: Array<String>) {
    val (asmFile, outFile) =
        (args.takeIf { it.size == 2 } ?: throw Exception("Arguments!"))
            .let { it.component1() to it.component2() }
            .let {
                Pair(
                    File(it.first)
                        .takeIf { f -> f.exists() } ?: throw Exception("Asm file not exist"),
                    File(it.second).also { f -> f.createNewFile() }
                )
            }

    val tree = asmFile.inputStream()
        .let { CharStreams.fromStream(it) }
        .let { charStream -> MicroasmLexer(charStream) }
        .let { MicroasmParser(CommonTokenStream(it)) }
        .microasmFile()

    val snippetVisitor = SnippetVisitor()
    tree.accept(snippetVisitor)
    val snippets = snippetVisitor.snippets


}
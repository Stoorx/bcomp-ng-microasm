package me.stoorx.bcompNgMicroasm.ast

import me.stoorx.bcompNgMicroasm.elements.Valve

interface ValveContainer {
    val valves: Collection<Valve>
}

class SnippetElement(
    val name: String,
    val valveContainers: Collection<ValveContainer>
) : ValveContainer {
    override val valves: Collection<Valve>
        get() = valveContainers.flatMap { it.valves }

    override fun toString(): String {
        return "Snippet `$name`: ${valves.joinToString { "$it" }}"
    }
}
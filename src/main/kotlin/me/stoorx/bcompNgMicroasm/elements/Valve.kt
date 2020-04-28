package me.stoorx.bcompNgMicroasm.elements

import me.stoorx.bcompNgMicroasm.ast.ValveContainer

enum class Valve(val valveOrdinal: Int) : ValveContainer {
    // Registers read
    RDAC(0),
    RDBR(1),
    RDPS(2),
    RDIR(3),
    RDCR(4),
    RDIP(5),
    RDSP(6),
    RDAR(7),
    RDDR(8),

    // ALU control
    COML(9),
    COMR(10),
    SORA(11),
    PLS1(12),

    // Switch control
    LTOL(13),
    HTOL(14),
    LTOH(15),
    HTOH(16),
    SEXT(17),
    SHLT(18),
    SHL0(19),
    SHRT(20),
    SHRF(21),

    // Flag checker control
    SETC(22),
    SETV(23),
    STNZ(24),

    // Registers write
    WRAC(25),
    WRBR(26),
    WRPS(27),
    WRCR(28),
    WRIP(29),
    WRSP(30),
    WRAR(31),
    WRDR(32),

    // Memory control
    LOAD(33),
    STOR(34),

    // Reserved bits
    RESERVED35(35),
    RESERVED36(36),
    RESERVED37(37),
    RESERVED38(38),
    RESERVED39(39),

    // Extension registers control
    RPTR(40),
    WPTR(41),
    RITR(42),
    WITR(43),
    RITL(44),
    WITL(45),

    // Machine control
    HALT(46),
    TYPE(47);

    override val valves: Collection<Valve>
        get() = listOf(this)

    override fun toString(): String {
        return "(${this.name}:${this.valveOrdinal})"
    }
}
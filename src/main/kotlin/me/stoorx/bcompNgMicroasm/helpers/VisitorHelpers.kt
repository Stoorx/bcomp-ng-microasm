package me.stoorx.bcompNgMicroasm.helpers

import me.stoorx.bcompNgMicroasm.elements.BooleanValue
import me.stoorx.bcompNgMicroasm.elements.Valve
import me.stoorx.bcompNgMicroasm.gen.MicroasmParser
import org.antlr.v4.runtime.Token

object VisitorHelpers {
    fun valveTokenToValve(token: Token): Valve =
        when (token.type) {
            MicroasmParser.ValveRDAC -> Valve.RDAC
            MicroasmParser.ValveRDBR -> Valve.RDBR
            MicroasmParser.ValveRDPS -> Valve.RDPS
            MicroasmParser.ValveRDIR -> Valve.RDIR
            MicroasmParser.ValveRDCR -> Valve.RDCR
            MicroasmParser.ValveRDIP -> Valve.RDIP
            MicroasmParser.ValveRDSP -> Valve.RDSP
            MicroasmParser.ValveRDAR -> Valve.RDAR
            MicroasmParser.ValveRDDR -> Valve.RDDR

            MicroasmParser.ValveCOML -> Valve.COML
            MicroasmParser.ValveCOMR -> Valve.COMR
            MicroasmParser.ValveSORA -> Valve.SORA
            MicroasmParser.ValvePLS1 -> Valve.PLS1

            MicroasmParser.ValveLTOL -> Valve.LTOL
            MicroasmParser.ValveHTOL -> Valve.HTOL
            MicroasmParser.ValveLTOH -> Valve.LTOH
            MicroasmParser.ValveHTOH -> Valve.HTOH
            MicroasmParser.ValveSEXT -> Valve.SEXT
            MicroasmParser.ValveSHLT -> Valve.SHLT
            MicroasmParser.ValveSHL0 -> Valve.SHL0
            MicroasmParser.ValveSHRT -> Valve.SHRT
            MicroasmParser.ValveSHRF -> Valve.SHRF

            MicroasmParser.ValveSETC -> Valve.SETC
            MicroasmParser.ValveSETV -> Valve.SETV
            MicroasmParser.ValveSTNZ -> Valve.STNZ

            MicroasmParser.ValveWRAC -> Valve.WRAC
            MicroasmParser.ValveWRBR -> Valve.WRBR
            MicroasmParser.ValveWRPS -> Valve.WRPS
            MicroasmParser.ValveWRCR -> Valve.WRCR
            MicroasmParser.ValveWRIP -> Valve.WRIP
            MicroasmParser.ValveWRSP -> Valve.WRSP
            MicroasmParser.ValveWRAR -> Valve.WRAR
            MicroasmParser.ValveWRDR -> Valve.WRDR

            MicroasmParser.ValveLOAD -> Valve.LOAD
            MicroasmParser.ValveSTOR -> Valve.STOR

            MicroasmParser.ValveRPTR -> Valve.RPTR
            MicroasmParser.ValveWPTR -> Valve.WPTR
            MicroasmParser.ValveRITR -> Valve.RITR
            MicroasmParser.ValveWITR -> Valve.WITR
            MicroasmParser.ValveRITL -> Valve.RITL
            MicroasmParser.ValveWITL -> Valve.WITL

            MicroasmParser.ValveHALT -> Valve.HALT

            else -> throw Exception("ERROR at ${token.line}:${token.charPositionInLine}: Invalid valve type")
        }

    fun booleanTokenToBooleanValue(token: Token): BooleanValue =
        when (token.text) {
            "0" -> BooleanValue.FALSE
            "1" -> BooleanValue.TRUE
            else -> throw Exception("ERROR at ${token.line}:${token.charPositionInLine}: Cannot convert ${token.text} to BooleanValue")
        }


}
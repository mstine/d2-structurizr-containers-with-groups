package net.falkenslabyrinth.elbanco.d2exporter

import com.structurizr.dsl.StructurizrDslParser
import io.github.goto1134.structurizr.export.d2.D2Exporter
import java.io.File

fun main() {
    File("d2").mkdirs()
    StructurizrDslParser().let {
        it.parse(File("dsl/workspace.dsl"))
        D2Exporter().export(it.workspace).forEach { diagram ->
            File("d2/${diagram.key}.d2").writeText(diagram.definition)
        }
    }
}
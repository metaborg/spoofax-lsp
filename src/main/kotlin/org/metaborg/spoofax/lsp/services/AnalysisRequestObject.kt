package org.metaborg.spoofax.lsp.services

import org.apache.commons.vfs2.FileObject
import org.metaborg.core.project.IProject
import org.metaborg.spoofax.core.unit.ISpoofaxInputUnit
import org.metaborg.spoofax.core.unit.ISpoofaxParseUnit

/**
 * A Container object for two objects, a document file and a root object.
 */
class AnalysisRequestObject(
        val inputUnit: ISpoofaxInputUnit,
        var parseUnit: ISpoofaxParseUnit?,
        var project : IProject?,
        val root : FileObject
)
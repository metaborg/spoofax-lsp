package org.metaborg.spoofax.lsp.services.diagnostic

import org.eclipse.lsp4j.Diagnostic
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject

class SpoofaxParserDiagnosticServiceImpl : SpoofaxParserDiagnosticService {
    override fun performParsing(request: AnalysisRequestObject): List<Diagnostic> {
        TODO("not implemented")
    }
}
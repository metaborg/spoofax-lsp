package org.metaborg.spoofax.lsp.services.diagnostic

import org.eclipse.lsp4j.Diagnostic
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject

class SpoofaxAnalysisDiagnosticServiceImpl : SpoofaxAnalysisDiagnosticService {
    override fun diagnose(request: AnalysisRequestObject): List<Diagnostic> {
        TODO("not implemented")
    }
}
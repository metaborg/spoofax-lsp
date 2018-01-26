package org.metaborg.spoofax.lsp.services.diagnostic

import com.google.inject.Inject
import org.eclipse.lsp4j.Diagnostic
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject
import org.metaborg.spoofax.lsp.services.converter.DiagnosticConverterService

class SpoofaxDiagnosticServiceImpl @Inject constructor(
        private val spoofaxAnalysisDiagnosticService: SpoofaxAnalysisDiagnosticService,
        private val spoofaxParserDiagnosticService: SpoofaxParserDiagnosticService,
        private val diagnosticConverterService: DiagnosticConverterService
): SpoofaxDiagnosticService {
    /**
     * Computes diagnostics, if Parsing succeeds then analysis is performed.
     */
    override fun performAnalysis(request: AnalysisRequestObject): List<Diagnostic> {
        return spoofaxParserDiagnosticService.performParsing(request)?.run{
            when(success()) {
                false ->
                    messages().map(diagnosticConverterService::convert)
                true ->
                    spoofaxAnalysisDiagnosticService.diagnose(request)?.result()?.run {
                    messages().map(diagnosticConverterService::convert)
                } ?: emptyList<Diagnostic>()
            }
        } ?: emptyList<Diagnostic>()
    }
}
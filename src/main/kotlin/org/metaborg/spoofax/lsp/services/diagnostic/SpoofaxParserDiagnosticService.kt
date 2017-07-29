package org.metaborg.spoofax.lsp.services.diagnostic

import org.eclipse.lsp4j.Diagnostic
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject

/**
 * @author  Thomas Kluiters
 * @since   1.0.0
 */
interface SpoofaxParserDiagnosticService {

    fun performParsing(request : AnalysisRequestObject): List<Diagnostic>

}
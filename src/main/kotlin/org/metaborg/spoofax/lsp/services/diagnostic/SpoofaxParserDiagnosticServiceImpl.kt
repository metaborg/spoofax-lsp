package org.metaborg.spoofax.lsp.services.diagnostic

import com.google.inject.Inject
import org.metaborg.core.syntax.ParseException
import org.metaborg.spoofax.core.syntax.ISpoofaxSyntaxService
import org.metaborg.spoofax.core.unit.ISpoofaxParseUnit
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject
import org.slf4j.Logger

class SpoofaxParserDiagnosticServiceImpl @Inject constructor(
        val syntaxService: ISpoofaxSyntaxService
) : SpoofaxParserDiagnosticService {

    @Inject
    lateinit var logger : Logger

    override fun performParsing(request: AnalysisRequestObject): ISpoofaxParseUnit? {
        return try {
            request.apply {
                parseUnit = syntaxService.parse(inputUnit)
            }.parseUnit
        } catch (ex : ParseException) {
            logger.error("Parsing {} failed, returning empty list. Failed with exception {}", request, ex).run { null }
        }
    }
}
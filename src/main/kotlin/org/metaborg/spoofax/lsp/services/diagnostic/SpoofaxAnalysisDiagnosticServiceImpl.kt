package org.metaborg.spoofax.lsp.services.diagnostic

import com.google.inject.Inject
import com.google.inject.Singleton
import org.metaborg.core.analysis.AnalysisException
import org.metaborg.core.context.ContextException
import org.metaborg.core.context.IContextService
import org.metaborg.spoofax.core.analysis.ISpoofaxAnalysisService
import org.metaborg.spoofax.core.analysis.ISpoofaxAnalyzeResult
import org.metaborg.spoofax.lsp.services.AnalysisRequestObject
import org.slf4j.Logger

class SpoofaxAnalysisDiagnosticServiceImpl @Inject constructor(
        val spoofaxAnalysisService: ISpoofaxAnalysisService,
        val contextService : IContextService
) : SpoofaxAnalysisDiagnosticService {

    @Inject
    lateinit var logger : Logger

    override fun diagnose(request: AnalysisRequestObject): ISpoofaxAnalyzeResult? {
        return try {
            contextService[request.inputUnit.source(), request.project, request.inputUnit.langImpl()].run {
                write().let {
                    spoofaxAnalysisService.analyze(request.parseUnit, this)
                }
            }
        } catch (ex : ContextException) {
            logger.error("Could not create IContext for input {}, failed with exception {}", request, ex).run { null }
        } catch (ex : AnalysisException) {
            logger.error("Could not analyze request for input {}, failed with exception {}", request, ex).run { null }
        }
    }
}
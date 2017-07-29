package org.metaborg.spoofax.lsp.services.converter

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.lsp4j.Diagnostic
import org.metaborg.core.messages.IMessage
import org.slf4j.Logger

@Singleton
class DiagnosticConverterServiceImpl @Inject constructor(
        val rangeConverterService: RangeConverterService,
        val severityConverterService: SeverityConverterService
) : DiagnosticConverterService {

    @Inject
    lateinit var logger : Logger

    override fun convert(from: IMessage?): Diagnostic {
        return from?.run {
            Diagnostic(
                rangeConverterService.convert(region()),
                message(),
                severityConverterService.convert(severity()),
                "Spoofax Language"
            )
        } ?: Diagnostic().apply{
            logger.warn("Supplied IMessage is null! Returning default {}", this)
        }
    }
}
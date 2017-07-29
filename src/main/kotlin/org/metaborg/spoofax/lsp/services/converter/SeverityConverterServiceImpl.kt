package org.metaborg.spoofax.lsp.services.converter

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.lsp4j.DiagnosticSeverity
import org.metaborg.core.messages.MessageSeverity
import org.slf4j.Logger


@Singleton
class SeverityConverterServiceImpl : SeverityConverterService {

    @Inject
    lateinit var logger : Logger

    override fun convert(from: MessageSeverity?): DiagnosticSeverity {
        return when(from) {
            MessageSeverity.NOTE -> DiagnosticSeverity.Information
            MessageSeverity.ERROR -> DiagnosticSeverity.Error
            MessageSeverity.WARNING -> DiagnosticSeverity.Warning
            null -> {
                DiagnosticSeverity.Information.apply {
                    logger.warn("Supplied MessageSeverity is null! Returning default {}", this)
                }
            }
        }
    }
}
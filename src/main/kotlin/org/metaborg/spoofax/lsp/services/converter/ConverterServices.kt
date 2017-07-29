package org.metaborg.spoofax.lsp.services.converter

import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Location
import org.eclipse.lsp4j.Range
import org.metaborg.core.messages.IMessage
import org.metaborg.core.messages.MessageSeverity
import org.metaborg.core.source.ISourceLocation
import org.metaborg.core.source.ISourceRegion
import org.metaborg.spoofax.lsp.services.ConverterService

/**
 * A Collections of interfaces for converting Spoofax objects to LSP objects.
 */
interface DiagnosticConverterService : ConverterService<IMessage?, Diagnostic>
interface LocationConverterService : ConverterService<ISourceLocation?, Location>
interface RangeConverterService : ConverterService<ISourceRegion?, Range>
interface SeverityConverterService : ConverterService<MessageSeverity?, DiagnosticSeverity>